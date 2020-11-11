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
    private int okJ = 0;
    private int mCount = 0;
    private boolean okK = false;

    static {
        $assertionsDisabled = !b.class.desiredAssertionStatus();
    }

    public boolean aS(E e) {
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
        if (!$assertionsDisabled && this.okJ != 0) {
            throw new AssertionError();
        }
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            if (this.mObservers.get(size) == null) {
                this.mObservers.remove(size);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebi() {
        this.okJ++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebj() {
        this.okJ--;
        if (!$assertionsDisabled && this.okJ < 0) {
            throw new AssertionError();
        }
        if (this.okJ <= 0 && this.okK) {
            this.okK = false;
            compact();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int capacity() {
        return this.mObservers.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public E MF(int i) {
        return this.mObservers.get(i);
    }

    /* loaded from: classes17.dex */
    private class a implements c<E> {
        private int mIndex;
        private int okL;
        private boolean okM;

        private a() {
            this.mIndex = 0;
            this.okM = false;
            b.this.ebi();
            this.okL = b.this.capacity();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i = this.mIndex;
            while (i < this.okL && b.this.MF(i) == null) {
                i++;
            }
            if (i < this.okL) {
                return true;
            }
            ebk();
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            while (this.mIndex < this.okL && b.this.MF(this.mIndex) == null) {
                this.mIndex++;
            }
            if (this.mIndex < this.okL) {
                b bVar = b.this;
                int i = this.mIndex;
                this.mIndex = i + 1;
                return (E) bVar.MF(i);
            }
            ebk();
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private void ebk() {
            if (!this.okM) {
                this.okM = true;
                b.this.ebj();
            }
        }
    }
}
