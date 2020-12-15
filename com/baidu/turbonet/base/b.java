package com.baidu.turbonet.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes14.dex */
public class b<E> implements Iterable<E> {
    static final /* synthetic */ boolean $assertionsDisabled;
    public final List<E> mObservers = new ArrayList();
    private int oBn = 0;
    private int mCount = 0;
    private boolean oBo = false;

    static {
        $assertionsDisabled = !b.class.desiredAssertionStatus();
    }

    public boolean aT(E e) {
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
        if (!$assertionsDisabled && this.oBn != 0) {
            throw new AssertionError();
        }
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            if (this.mObservers.get(size) == null) {
                this.mObservers.remove(size);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egN() {
        this.oBn++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egO() {
        this.oBn--;
        if (!$assertionsDisabled && this.oBn < 0) {
            throw new AssertionError();
        }
        if (this.oBn <= 0 && this.oBo) {
            this.oBo = false;
            compact();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int capacity() {
        return this.mObservers.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public E Oa(int i) {
        return this.mObservers.get(i);
    }

    /* loaded from: classes14.dex */
    private class a implements c<E> {
        private int mIndex;
        private int oBp;
        private boolean oBq;

        private a() {
            this.mIndex = 0;
            this.oBq = false;
            b.this.egN();
            this.oBp = b.this.capacity();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i = this.mIndex;
            while (i < this.oBp && b.this.Oa(i) == null) {
                i++;
            }
            if (i < this.oBp) {
                return true;
            }
            egP();
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            while (this.mIndex < this.oBp && b.this.Oa(this.mIndex) == null) {
                this.mIndex++;
            }
            if (this.mIndex < this.oBp) {
                b bVar = b.this;
                int i = this.mIndex;
                this.mIndex = i + 1;
                return (E) bVar.Oa(i);
            }
            egP();
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private void egP() {
            if (!this.oBq) {
                this.oBq = true;
                b.this.egO();
            }
        }
    }
}
