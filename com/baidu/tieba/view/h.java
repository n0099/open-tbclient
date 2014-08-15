package com.baidu.tieba.view;

import java.util.List;
/* loaded from: classes.dex */
class h {
    public final boolean a;
    public final List<Object> b;
    public final List<Object> c;

    public static h a(List<Object> list, List<Object> list2) {
        return new h(true, list, list2);
    }

    public static h a() {
        return new h(false, null, null);
    }

    private h(boolean z, List<Object> list, List<Object> list2) {
        this.a = z;
        this.b = list;
        this.c = list2;
    }
}
