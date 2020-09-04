package com.baidu.turbonet.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes10.dex */
public class b<E> implements Iterable<E> {
    static final /* synthetic */ boolean $assertionsDisabled;
    public final List<E> mObservers = new ArrayList();
    private int mZI = 0;
    private int mCount = 0;
    private boolean mZJ = false;

    static {
        $assertionsDisabled = !b.class.desiredAssertionStatus();
    }

    public boolean aM(E e) {
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
        if (!$assertionsDisabled && this.mZI != 0) {
            throw new AssertionError();
        }
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            if (this.mObservers.get(size) == null) {
                this.mObservers.remove(size);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJY() {
        this.mZI++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJZ() {
        this.mZI--;
        if (!$assertionsDisabled && this.mZI < 0) {
            throw new AssertionError();
        }
        if (this.mZI <= 0 && this.mZJ) {
            this.mZJ = false;
            compact();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int capacity() {
        return this.mObservers.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public E JZ(int i) {
        return this.mObservers.get(i);
    }

    /* loaded from: classes10.dex */
    private class a implements c<E> {
        private int mIndex;
        private int mZK;
        private boolean mZL;

        private a() {
            this.mIndex = 0;
            this.mZL = false;
            b.this.dJY();
            this.mZK = b.this.capacity();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i = this.mIndex;
            while (i < this.mZK && b.this.JZ(i) == null) {
                i++;
            }
            if (i < this.mZK) {
                return true;
            }
            dKa();
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            while (this.mIndex < this.mZK && b.this.JZ(this.mIndex) == null) {
                this.mIndex++;
            }
            if (this.mIndex < this.mZK) {
                b bVar = b.this;
                int i = this.mIndex;
                this.mIndex = i + 1;
                return (E) bVar.JZ(i);
            }
            dKa();
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private void dKa() {
            if (!this.mZL) {
                this.mZL = true;
                b.this.dJZ();
            }
        }
    }
}
