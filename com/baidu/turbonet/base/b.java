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
    private int myk = 0;
    private int mCount = 0;
    private boolean myl = false;

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
        if (!$assertionsDisabled && this.myk != 0) {
            throw new AssertionError();
        }
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            if (this.mObservers.get(size) == null) {
                this.mObservers.remove(size);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duO() {
        this.myk++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duP() {
        this.myk--;
        if (!$assertionsDisabled && this.myk < 0) {
            throw new AssertionError();
        }
        if (this.myk <= 0 && this.myl) {
            this.myl = false;
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
        private int mym;
        private boolean myn;

        private a() {
            this.mIndex = 0;
            this.myn = false;
            b.this.duO();
            this.mym = b.this.capacity();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i = this.mIndex;
            while (i < this.mym && b.this.He(i) == null) {
                i++;
            }
            if (i < this.mym) {
                return true;
            }
            duQ();
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            while (this.mIndex < this.mym && b.this.He(this.mIndex) == null) {
                this.mIndex++;
            }
            if (this.mIndex < this.mym) {
                b bVar = b.this;
                int i = this.mIndex;
                this.mIndex = i + 1;
                return (E) bVar.He(i);
            }
            duQ();
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private void duQ() {
            if (!this.myn) {
                this.myn = true;
                b.this.duP();
            }
        }
    }
}
