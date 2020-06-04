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
    private int mcs = 0;
    private int mCount = 0;
    private boolean mct = false;

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
        if (!$assertionsDisabled && this.mcs != 0) {
            throw new AssertionError();
        }
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            if (this.mObservers.get(size) == null) {
                this.mObservers.remove(size);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqf() {
        this.mcs++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqg() {
        this.mcs--;
        if (!$assertionsDisabled && this.mcs < 0) {
            throw new AssertionError();
        }
        if (this.mcs <= 0 && this.mct) {
            this.mct = false;
            compact();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int capacity() {
        return this.mObservers.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public E FX(int i) {
        return this.mObservers.get(i);
    }

    /* loaded from: classes.dex */
    private class a implements c<E> {
        private int mIndex;
        private int mcu;
        private boolean mcv;

        private a() {
            this.mIndex = 0;
            this.mcv = false;
            b.this.dqf();
            this.mcu = b.this.capacity();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i = this.mIndex;
            while (i < this.mcu && b.this.FX(i) == null) {
                i++;
            }
            if (i < this.mcu) {
                return true;
            }
            dqh();
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            while (this.mIndex < this.mcu && b.this.FX(this.mIndex) == null) {
                this.mIndex++;
            }
            if (this.mIndex < this.mcu) {
                b bVar = b.this;
                int i = this.mIndex;
                this.mIndex = i + 1;
                return (E) bVar.FX(i);
            }
            dqh();
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private void dqh() {
            if (!this.mcv) {
                this.mcv = true;
                b.this.dqg();
            }
        }
    }
}
