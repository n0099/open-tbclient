package com.baidu.turbonet.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes19.dex */
public class b<E> implements Iterable<E> {
    static final /* synthetic */ boolean $assertionsDisabled;
    public final List<E> mObservers = new ArrayList();
    private int mGr = 0;
    private int mCount = 0;
    private boolean mGs = false;

    static {
        $assertionsDisabled = !b.class.desiredAssertionStatus();
    }

    public boolean aK(E e) {
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
        if (!$assertionsDisabled && this.mGr != 0) {
            throw new AssertionError();
        }
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            if (this.mObservers.get(size) == null) {
                this.mObservers.remove(size);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyc() {
        this.mGr++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyd() {
        this.mGr--;
        if (!$assertionsDisabled && this.mGr < 0) {
            throw new AssertionError();
        }
        if (this.mGr <= 0 && this.mGs) {
            this.mGs = false;
            compact();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int capacity() {
        return this.mObservers.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public E Hz(int i) {
        return this.mObservers.get(i);
    }

    /* loaded from: classes19.dex */
    private class a implements c<E> {
        private int mGt;
        private boolean mGu;
        private int mIndex;

        private a() {
            this.mIndex = 0;
            this.mGu = false;
            b.this.dyc();
            this.mGt = b.this.capacity();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i = this.mIndex;
            while (i < this.mGt && b.this.Hz(i) == null) {
                i++;
            }
            if (i < this.mGt) {
                return true;
            }
            dye();
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            while (this.mIndex < this.mGt && b.this.Hz(this.mIndex) == null) {
                this.mIndex++;
            }
            if (this.mIndex < this.mGt) {
                b bVar = b.this;
                int i = this.mIndex;
                this.mIndex = i + 1;
                return (E) bVar.Hz(i);
            }
            dye();
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private void dye() {
            if (!this.mGu) {
                this.mGu = true;
                b.this.dyd();
            }
        }
    }
}
