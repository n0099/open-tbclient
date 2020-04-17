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
    private int lHN = 0;
    private int mCount = 0;
    private boolean lHO = false;

    static {
        $assertionsDisabled = !b.class.desiredAssertionStatus();
    }

    public boolean aF(E e) {
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
        if (!$assertionsDisabled && this.lHN != 0) {
            throw new AssertionError();
        }
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            if (this.mObservers.get(size) == null) {
                this.mObservers.remove(size);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diC() {
        this.lHN++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diD() {
        this.lHN--;
        if (!$assertionsDisabled && this.lHN < 0) {
            throw new AssertionError();
        }
        if (this.lHN <= 0 && this.lHO) {
            this.lHO = false;
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
        private int lHP;
        private boolean lHQ;
        private int mIndex;

        private a() {
            this.mIndex = 0;
            this.lHQ = false;
            b.this.diC();
            this.lHP = b.this.capacity();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i = this.mIndex;
            while (i < this.lHP && b.this.Fi(i) == null) {
                i++;
            }
            if (i < this.lHP) {
                return true;
            }
            diE();
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            while (this.mIndex < this.lHP && b.this.Fi(this.mIndex) == null) {
                this.mIndex++;
            }
            if (this.mIndex < this.lHP) {
                b bVar = b.this;
                int i = this.mIndex;
                this.mIndex = i + 1;
                return (E) bVar.Fi(i);
            }
            diE();
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private void diE() {
            if (!this.lHQ) {
                this.lHQ = true;
                b.this.diD();
            }
        }
    }
}
