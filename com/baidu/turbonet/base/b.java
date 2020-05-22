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
    private int mbi = 0;
    private int mCount = 0;
    private boolean mbj = false;

    static {
        $assertionsDisabled = !b.class.desiredAssertionStatus();
    }

    public boolean aJ(E e) {
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
        if (!$assertionsDisabled && this.mbi != 0) {
            throw new AssertionError();
        }
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            if (this.mObservers.get(size) == null) {
                this.mObservers.remove(size);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpR() {
        this.mbi++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpS() {
        this.mbi--;
        if (!$assertionsDisabled && this.mbi < 0) {
            throw new AssertionError();
        }
        if (this.mbi <= 0 && this.mbj) {
            this.mbj = false;
            compact();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int capacity() {
        return this.mObservers.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public E FV(int i) {
        return this.mObservers.get(i);
    }

    /* loaded from: classes.dex */
    private class a implements c<E> {
        private int mIndex;
        private int mbk;
        private boolean mbl;

        private a() {
            this.mIndex = 0;
            this.mbl = false;
            b.this.dpR();
            this.mbk = b.this.capacity();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i = this.mIndex;
            while (i < this.mbk && b.this.FV(i) == null) {
                i++;
            }
            if (i < this.mbk) {
                return true;
            }
            dpT();
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            while (this.mIndex < this.mbk && b.this.FV(this.mIndex) == null) {
                this.mIndex++;
            }
            if (this.mIndex < this.mbk) {
                b bVar = b.this;
                int i = this.mIndex;
                this.mIndex = i + 1;
                return (E) bVar.FV(i);
            }
            dpT();
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private void dpT() {
            if (!this.mbl) {
                this.mbl = true;
                b.this.dpS();
            }
        }
    }
}
