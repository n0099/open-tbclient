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
    private int myh = 0;
    private int mCount = 0;
    private boolean myi = false;

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
        if (!$assertionsDisabled && this.myh != 0) {
            throw new AssertionError();
        }
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            if (this.mObservers.get(size) == null) {
                this.mObservers.remove(size);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duK() {
        this.myh++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duL() {
        this.myh--;
        if (!$assertionsDisabled && this.myh < 0) {
            throw new AssertionError();
        }
        if (this.myh <= 0 && this.myi) {
            this.myi = false;
            compact();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int capacity() {
        return this.mObservers.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public E He(int i) {
        return this.mObservers.get(i);
    }

    /* loaded from: classes.dex */
    private class a implements c<E> {
        private int mIndex;
        private int myj;
        private boolean myk;

        private a() {
            this.mIndex = 0;
            this.myk = false;
            b.this.duK();
            this.myj = b.this.capacity();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i = this.mIndex;
            while (i < this.myj && b.this.He(i) == null) {
                i++;
            }
            if (i < this.myj) {
                return true;
            }
            duM();
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            while (this.mIndex < this.myj && b.this.He(this.mIndex) == null) {
                this.mIndex++;
            }
            if (this.mIndex < this.myj) {
                b bVar = b.this;
                int i = this.mIndex;
                this.mIndex = i + 1;
                return (E) bVar.He(i);
            }
            duM();
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private void duM() {
            if (!this.myk) {
                this.myk = true;
                b.this.duL();
            }
        }
    }
}
