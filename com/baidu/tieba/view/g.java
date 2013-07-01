package com.baidu.tieba.view;

import java.util.List;
/* loaded from: classes.dex */
class g {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1520a;
    public final List b;
    public final List c;

    public static g a(List list, List list2) {
        return new g(true, list, list2);
    }

    public static g a() {
        return new g(false, null, null);
    }

    private g(boolean z, List list, List list2) {
        this.f1520a = z;
        this.b = list;
        this.c = list2;
    }
}
