package com.baidu.tieba.view;

import java.util.List;
/* loaded from: classes.dex */
class t {
    public final boolean a;
    public final List<Object> b;
    public final List<Object> c;

    public static t a(List<Object> list, List<Object> list2) {
        return new t(true, list, list2);
    }

    public static t a() {
        return new t(false, null, null);
    }

    private t(boolean z, List<Object> list, List<Object> list2) {
        this.a = z;
        this.b = list;
        this.c = list2;
    }
}
