package com.baidu.tieba.view;

import java.util.List;
/* loaded from: classes.dex */
class i {
    public final boolean a;
    public final List<Object> b;
    public final List<Object> c;

    public static i a(List<Object> list, List<Object> list2) {
        return new i(true, list, list2);
    }

    public static i a() {
        return new i(false, null, null);
    }

    private i(boolean z, List<Object> list, List<Object> list2) {
        this.a = z;
        this.b = list;
        this.c = list2;
    }
}
