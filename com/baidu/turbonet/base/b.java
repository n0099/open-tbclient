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
    private int oBl = 0;
    private int mCount = 0;
    private boolean oBm = false;

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
        if (!$assertionsDisabled && this.oBl != 0) {
            throw new AssertionError();
        }
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            if (this.mObservers.get(size) == null) {
                this.mObservers.remove(size);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egM() {
        this.oBl++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egN() {
        this.oBl--;
        if (!$assertionsDisabled && this.oBl < 0) {
            throw new AssertionError();
        }
        if (this.oBl <= 0 && this.oBm) {
            this.oBm = false;
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
        private int oBn;
        private boolean oBo;

        private a() {
            this.mIndex = 0;
            this.oBo = false;
            b.this.egM();
            this.oBn = b.this.capacity();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i = this.mIndex;
            while (i < this.oBn && b.this.Oa(i) == null) {
                i++;
            }
            if (i < this.oBn) {
                return true;
            }
            egO();
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            while (this.mIndex < this.oBn && b.this.Oa(this.mIndex) == null) {
                this.mIndex++;
            }
            if (this.mIndex < this.oBn) {
                b bVar = b.this;
                int i = this.mIndex;
                this.mIndex = i + 1;
                return (E) bVar.Oa(i);
            }
            egO();
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private void egO() {
            if (!this.oBo) {
                this.oBo = true;
                b.this.egN();
            }
        }
    }
}
