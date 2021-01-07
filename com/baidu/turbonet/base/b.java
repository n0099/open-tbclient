package com.baidu.turbonet.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes5.dex */
public class b<E> implements Iterable<E> {
    static final /* synthetic */ boolean $assertionsDisabled;
    public final List<E> mObservers = new ArrayList();
    private int mIterationDepth = 0;
    private int mCount = 0;
    private boolean mNeedsCompact = false;

    static {
        $assertionsDisabled = !b.class.desiredAssertionStatus();
    }

    public boolean addObserver(E e) {
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
        if (!$assertionsDisabled && this.mIterationDepth != 0) {
            throw new AssertionError();
        }
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            if (this.mObservers.get(size) == null) {
                this.mObservers.remove(size);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eht() {
        this.mIterationDepth++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ehu() {
        this.mIterationDepth--;
        if (!$assertionsDisabled && this.mIterationDepth < 0) {
            throw new AssertionError();
        }
        if (this.mIterationDepth <= 0 && this.mNeedsCompact) {
            this.mNeedsCompact = false;
            compact();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int capacity() {
        return this.mObservers.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public E NU(int i) {
        return this.mObservers.get(i);
    }

    /* loaded from: classes5.dex */
    private class a implements c<E> {
        private int mIndex;
        private boolean mIsExhausted;
        private int mListEndMarker;

        private a() {
            this.mIndex = 0;
            this.mIsExhausted = false;
            b.this.eht();
            this.mListEndMarker = b.this.capacity();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i = this.mIndex;
            while (i < this.mListEndMarker && b.this.NU(i) == null) {
                i++;
            }
            if (i < this.mListEndMarker) {
                return true;
            }
            ehv();
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            while (this.mIndex < this.mListEndMarker && b.this.NU(this.mIndex) == null) {
                this.mIndex++;
            }
            if (this.mIndex < this.mListEndMarker) {
                b bVar = b.this;
                int i = this.mIndex;
                this.mIndex = i + 1;
                return (E) bVar.NU(i);
            }
            ehv();
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private void ehv() {
            if (!this.mIsExhausted) {
                this.mIsExhausted = true;
                b.this.ehu();
            }
        }
    }
}
