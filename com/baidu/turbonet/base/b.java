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
    private int mGp = 0;
    private int mCount = 0;
    private boolean mGq = false;

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
        if (!$assertionsDisabled && this.mGp != 0) {
            throw new AssertionError();
        }
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            if (this.mObservers.get(size) == null) {
                this.mObservers.remove(size);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyb() {
        this.mGp++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyc() {
        this.mGp--;
        if (!$assertionsDisabled && this.mGp < 0) {
            throw new AssertionError();
        }
        if (this.mGp <= 0 && this.mGq) {
            this.mGq = false;
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
        private int mGr;
        private boolean mGs;
        private int mIndex;

        private a() {
            this.mIndex = 0;
            this.mGs = false;
            b.this.dyb();
            this.mGr = b.this.capacity();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i = this.mIndex;
            while (i < this.mGr && b.this.Hz(i) == null) {
                i++;
            }
            if (i < this.mGr) {
                return true;
            }
            dyd();
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            while (this.mIndex < this.mGr && b.this.Hz(this.mIndex) == null) {
                this.mIndex++;
            }
            if (this.mIndex < this.mGr) {
                b bVar = b.this;
                int i = this.mIndex;
                this.mIndex = i + 1;
                return (E) bVar.Hz(i);
            }
            dyd();
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private void dyd() {
            if (!this.mGs) {
                this.mGs = true;
                b.this.dyc();
            }
        }
    }
}
