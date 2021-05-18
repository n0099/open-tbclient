package com.baidu.ufosdk.f;

import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public final class e extends LinkedList {

    /* renamed from: a  reason: collision with root package name */
    public final int f22590a = 2000;

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public final boolean add(Object obj) {
        if (size() == this.f22590a) {
            removeFirst();
        }
        return super.add(obj);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
        }
        return sb.toString();
    }
}
