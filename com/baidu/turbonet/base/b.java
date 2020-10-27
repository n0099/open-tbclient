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
    private int obE = 0;
    private int mCount = 0;
    private boolean obF = false;

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
        if (!$assertionsDisabled && this.obE != 0) {
            throw new AssertionError();
        }
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            if (this.mObservers.get(size) == null) {
                this.mObservers.remove(size);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXA() {
        this.obE++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXB() {
        this.obE--;
        if (!$assertionsDisabled && this.obE < 0) {
            throw new AssertionError();
        }
        if (this.obE <= 0 && this.obF) {
            this.obF = false;
            compact();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int capacity() {
        return this.mObservers.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public E Mm(int i) {
        return this.mObservers.get(i);
    }

    /* loaded from: classes17.dex */
    private class a implements c<E> {
        private int mIndex;
        private int obG;
        private boolean obH;

        private a() {
            this.mIndex = 0;
            this.obH = false;
            b.this.dXA();
            this.obG = b.this.capacity();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i = this.mIndex;
            while (i < this.obG && b.this.Mm(i) == null) {
                i++;
            }
            if (i < this.obG) {
                return true;
            }
            dXC();
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            while (this.mIndex < this.obG && b.this.Mm(this.mIndex) == null) {
                this.mIndex++;
            }
            if (this.mIndex < this.obG) {
                b bVar = b.this;
                int i = this.mIndex;
                this.mIndex = i + 1;
                return (E) bVar.Mm(i);
            }
            dXC();
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private void dXC() {
            if (!this.obH) {
                this.obH = true;
                b.this.dXB();
            }
        }
    }
}
