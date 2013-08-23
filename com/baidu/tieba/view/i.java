package com.baidu.tieba.view;

import java.util.List;
/* loaded from: classes.dex */
class i {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1869a;
    public final List b;
    public final List c;

    public static i a(List list, List list2) {
        return new i(true, list, list2);
    }

    public static i a() {
        return new i(false, null, null);
    }

    private i(boolean z, List list, List list2) {
        this.f1869a = z;
        this.b = list;
        this.c = list2;
    }
}
