package com.baidu.turbonet.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes15.dex */
public class b<E> implements Iterable<E> {
    static final /* synthetic */ boolean $assertionsDisabled;
    public final List<E> mObservers = new ArrayList();
    private int njH = 0;
    private int mCount = 0;
    private boolean njI = false;

    static {
        $assertionsDisabled = !b.class.desiredAssertionStatus();
    }

    public boolean aO(E e) {
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
        if (!$assertionsDisabled && this.njH != 0) {
            throw new AssertionError();
        }
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            if (this.mObservers.get(size) == null) {
                this.mObservers.remove(size);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNW() {
        this.njH++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNX() {
        this.njH--;
        if (!$assertionsDisabled && this.njH < 0) {
            throw new AssertionError();
        }
        if (this.njH <= 0 && this.njI) {
            this.njI = false;
            compact();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int capacity() {
        return this.mObservers.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public E KE(int i) {
        return this.mObservers.get(i);
    }

    /* loaded from: classes15.dex */
    private class a implements c<E> {
        private int mIndex;
        private int njJ;
        private boolean njK;

        private a() {
            this.mIndex = 0;
            this.njK = false;
            b.this.dNW();
            this.njJ = b.this.capacity();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i = this.mIndex;
            while (i < this.njJ && b.this.KE(i) == null) {
                i++;
            }
            if (i < this.njJ) {
                return true;
            }
            dNY();
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            while (this.mIndex < this.njJ && b.this.KE(this.mIndex) == null) {
                this.mIndex++;
            }
            if (this.mIndex < this.njJ) {
                b bVar = b.this;
                int i = this.mIndex;
                this.mIndex = i + 1;
                return (E) bVar.KE(i);
            }
            dNY();
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private void dNY() {
            if (!this.njK) {
                this.njK = true;
                b.this.dNX();
            }
        }
    }
}
