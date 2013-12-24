package com.baidu.tieba.view;

import java.util.List;
/* loaded from: classes.dex */
class k {
    public final boolean a;
    public final List<Object> b;
    public final List<Object> c;

    public static k a(List<Object> list, List<Object> list2) {
        return new k(true, list, list2);
    }

    public static k a() {
        return new k(false, null, null);
    }

    private k(boolean z, List<Object> list, List<Object> list2) {
        this.a = z;
        this.b = list;
        this.c = list2;
    }
}
