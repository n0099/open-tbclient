package com.baidu.zeus;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.ListIterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ByteArrayBuilder {
    private static final int DEFAULT_CAPACITY = 8192;
    private static final LinkedList sPool = new LinkedList();
    private static final ReferenceQueue sQueue = new ReferenceQueue();
    private LinkedList mChunks = new LinkedList();

    public synchronized void append(byte[] bArr, int i, int i2) {
        Chunk chunk;
        while (i2 > 0) {
            if (this.mChunks.isEmpty()) {
                chunk = obtainChunk(i2);
                this.mChunks.addLast(chunk);
            } else {
                chunk = (Chunk) this.mChunks.getLast();
                if (chunk.mLength == chunk.mArray.length) {
                    chunk = obtainChunk(i2);
                    this.mChunks.addLast(chunk);
                }
            }
            int min = Math.min(i2, chunk.mArray.length - chunk.mLength);
            System.arraycopy(bArr, i, chunk.mArray, chunk.mLength, min);
            chunk.mLength += min;
            i2 -= min;
            i += min;
        }
    }

    public synchronized Chunk getFirstChunk() {
        return this.mChunks.isEmpty() ? null : (Chunk) this.mChunks.removeFirst();
    }

    public synchronized boolean isEmpty() {
        return this.mChunks.isEmpty();
    }

    public synchronized int getByteSize() {
        int i;
        int i2 = 0;
        synchronized (this) {
            ListIterator listIterator = this.mChunks.listIterator(0);
            while (true) {
                i = i2;
                if (listIterator.hasNext()) {
                    i2 = ((Chunk) listIterator.next()).mLength + i;
                }
            }
        }
        return i;
    }

    public synchronized void clear() {
        Chunk firstChunk = getFirstChunk();
        while (firstChunk != null) {
            firstChunk.release();
            firstChunk = getFirstChunk();
        }
    }

    private void processPoolLocked() {
        while (true) {
            SoftReference softReference = (SoftReference) sQueue.poll();
            if (softReference != null) {
                sPool.remove(softReference);
            } else {
                return;
            }
        }
    }

    private Chunk obtainChunk(int i) {
        Chunk chunk;
        if (i < DEFAULT_CAPACITY) {
            i = DEFAULT_CAPACITY;
        }
        synchronized (sPool) {
            processPoolLocked();
            if (sPool.isEmpty() || (chunk = (Chunk) ((SoftReference) sPool.removeFirst()).get()) == null) {
                chunk = new Chunk(i);
            }
        }
        return chunk;
    }

    /* loaded from: classes.dex */
    public class Chunk {
        public byte[] mArray;
        public int mLength = 0;

        public Chunk(int i) {
            this.mArray = new byte[i];
        }

        public void release() {
            this.mLength = 0;
            synchronized (ByteArrayBuilder.sPool) {
                ByteArrayBuilder.sPool.offer(new SoftReference(this, ByteArrayBuilder.sQueue));
                ByteArrayBuilder.sPool.notifyAll();
            }
        }
    }
}
