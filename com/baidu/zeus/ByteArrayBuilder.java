package com.baidu.zeus;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.ListIterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ByteArrayBuilder {
    private static final int DEFAULT_CAPACITY = 8192;
    private static final LinkedList<SoftReference<Chunk>> sPool = new LinkedList<>();
    private static final ReferenceQueue<Chunk> sQueue = new ReferenceQueue<>();
    private LinkedList<Chunk> mChunks = new LinkedList<>();

    public synchronized void append(byte[] bArr, int i, int i2) {
        Chunk last;
        while (i2 > 0) {
            if (this.mChunks.isEmpty()) {
                last = obtainChunk(i2);
                this.mChunks.addLast(last);
            } else {
                last = this.mChunks.getLast();
                if (last.mLength == last.mArray.length) {
                    last = obtainChunk(i2);
                    this.mChunks.addLast(last);
                }
            }
            int min = Math.min(i2, last.mArray.length - last.mLength);
            System.arraycopy(bArr, i, last.mArray, last.mLength, min);
            last.mLength += min;
            i2 -= min;
            i += min;
        }
    }

    public synchronized Chunk getFirstChunk() {
        return this.mChunks.isEmpty() ? null : this.mChunks.removeFirst();
    }

    public synchronized boolean isEmpty() {
        return this.mChunks.isEmpty();
    }

    public synchronized int getByteSize() {
        int i;
        int i2 = 0;
        synchronized (this) {
            ListIterator<Chunk> listIterator = this.mChunks.listIterator(0);
            while (true) {
                i = i2;
                if (listIterator.hasNext()) {
                    i2 = listIterator.next().mLength + i;
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
            if (sPool.isEmpty() || (chunk = sPool.removeFirst().get()) == null) {
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
