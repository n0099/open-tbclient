package com.baidu.ufosdk.f;

import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public final class e extends LinkedList {

    /* renamed from: a  reason: collision with root package name */
    private final int f3621a = 2000;

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public final boolean add(Object obj) {
        if (size() == this.f3621a) {
            removeFirst();
        }
        return super.add(obj);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
        }
        return sb.toString();
    }
}
