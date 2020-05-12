package com.baidu.turbonet.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes.dex */
public class b<E> implements Iterable<E> {
    static final /* synthetic */ boolean $assertionsDisabled;
    public final List<E> mObservers = new ArrayList();
    private int lHR = 0;
    private int mCount = 0;
    private boolean lHS = false;

    static {
        $assertionsDisabled = !b.class.desiredAssertionStatus();
    }

    public boolean aG(E e) {
        if (e == null || this.mObservers.contains(e)) {
            return false;
        }
        boolean add = this.mObservers.add(e);
        if ($assertionsDisabled || add) {
            this.mCount++;
            return true;
        }
        throw new AssertionError();
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return new a();
    }

    private void compact() {
        if (!$assertionsDisabled && this.lHR != 0) {
            throw new AssertionError();
        }
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            if (this.mObservers.get(size) == null) {
                this.mObservers.remove(size);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diA() {
        this.lHR++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diB() {
        this.lHR--;
        if (!$assertionsDisabled && this.lHR < 0) {
            throw new AssertionError();
        }
        if (this.lHR <= 0 && this.lHS) {
            this.lHS = false;
            compact();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int capacity() {
        return this.mObservers.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public E Fi(int i) {
        return this.mObservers.get(i);
    }

    /* loaded from: classes.dex */
    private class a implements c<E> {
        private int lHT;
        private boolean lHU;
        private int mIndex;

        private a() {
            this.mIndex = 0;
            this.lHU = false;
            b.this.diA();
            this.lHT = b.this.capacity();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i = this.mIndex;
            while (i < this.lHT && b.this.Fi(i) == null) {
                i++;
            }
            if (i < this.lHT) {
                return true;
            }
            diC();
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            while (this.mIndex < this.lHT && b.this.Fi(this.mIndex) == null) {
                this.mIndex++;
            }
            if (this.mIndex < this.lHT) {
                b bVar = b.this;
                int i = this.mIndex;
                this.mIndex = i + 1;
                return (E) bVar.Fi(i);
            }
            diC();
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private void diC() {
            if (!this.lHU) {
                this.lHU = true;
                b.this.diB();
            }
        }
    }
}
