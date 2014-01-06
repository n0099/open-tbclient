package com.baidu.tieba.view;

import java.util.List;
/* loaded from: classes.dex */
class p {
    public final boolean a;
    public final List<Object> b;
    public final List<Object> c;

    public static p a(List<Object> list, List<Object> list2) {
        return new p(true, list, list2);
    }

    public static p a() {
        return new p(false, null, null);
    }

    private p(boolean z, List<Object> list, List<Object> list2) {
        this.a = z;
        this.b = list;
        this.c = list2;
    }
}
