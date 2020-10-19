package com.baidu.turbonet.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes17.dex */
public class b<E> implements Iterable<E> {
    static final /* synthetic */ boolean $assertionsDisabled;
    public final List<E> mObservers = new ArrayList();
    private int nze = 0;
    private int mCount = 0;
    private boolean nzf = false;

    static {
        $assertionsDisabled = !b.class.desiredAssertionStatus();
    }

    public boolean aR(E e) {
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
        if (!$assertionsDisabled && this.nze != 0) {
            throw new AssertionError();
        }
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            if (this.mObservers.get(size) == null) {
                this.mObservers.remove(size);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dRI() {
        this.nze++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dRJ() {
        this.nze--;
        if (!$assertionsDisabled && this.nze < 0) {
            throw new AssertionError();
        }
        if (this.nze <= 0 && this.nzf) {
            this.nzf = false;
            compact();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int capacity() {
        return this.mObservers.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public E Lk(int i) {
        return this.mObservers.get(i);
    }

    /* loaded from: classes17.dex */
    private class a implements c<E> {
        private int mIndex;
        private int nzg;
        private boolean nzh;

        private a() {
            this.mIndex = 0;
            this.nzh = false;
            b.this.dRI();
            this.nzg = b.this.capacity();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i = this.mIndex;
            while (i < this.nzg && b.this.Lk(i) == null) {
                i++;
            }
            if (i < this.nzg) {
                return true;
            }
            dRK();
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            while (this.mIndex < this.nzg && b.this.Lk(this.mIndex) == null) {
                this.mIndex++;
            }
            if (this.mIndex < this.nzg) {
                b bVar = b.this;
                int i = this.mIndex;
                this.mIndex = i + 1;
                return (E) bVar.Lk(i);
            }
            dRK();
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private void dRK() {
            if (!this.nzh) {
                this.nzh = true;
                b.this.dRJ();
            }
        }
    }
}
