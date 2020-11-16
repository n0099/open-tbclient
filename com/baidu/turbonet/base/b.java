package com.baidu.turbonet.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes12.dex */
public class b<E> implements Iterable<E> {
    static final /* synthetic */ boolean $assertionsDisabled;
    public final List<E> mObservers = new ArrayList();
    private int omm = 0;
    private int mCount = 0;
    private boolean omn = false;

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
        if (!$assertionsDisabled && this.omm != 0) {
            throw new AssertionError();
        }
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            if (this.mObservers.get(size) == null) {
                this.mObservers.remove(size);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebh() {
        this.omm++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebi() {
        this.omm--;
        if (!$assertionsDisabled && this.omm < 0) {
            throw new AssertionError();
        }
        if (this.omm <= 0 && this.omn) {
            this.omn = false;
            compact();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int capacity() {
        return this.mObservers.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public E Ni(int i) {
        return this.mObservers.get(i);
    }

    /* loaded from: classes12.dex */
    private class a implements c<E> {
        private int mIndex;
        private int omo;
        private boolean omp;

        private a() {
            this.mIndex = 0;
            this.omp = false;
            b.this.ebh();
            this.omo = b.this.capacity();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i = this.mIndex;
            while (i < this.omo && b.this.Ni(i) == null) {
                i++;
            }
            if (i < this.omo) {
                return true;
            }
            ebj();
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            while (this.mIndex < this.omo && b.this.Ni(this.mIndex) == null) {
                this.mIndex++;
            }
            if (this.mIndex < this.omo) {
                b bVar = b.this;
                int i = this.mIndex;
                this.mIndex = i + 1;
                return (E) bVar.Ni(i);
            }
            ebj();
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private void ebj() {
            if (!this.omp) {
                this.omp = true;
                b.this.ebi();
            }
        }
    }
}
