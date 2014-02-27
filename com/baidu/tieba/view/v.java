package com.baidu.tieba.view;

import java.util.List;
/* loaded from: classes.dex */
final class v {
    public final boolean a;
    public final List<Object> b;
    public final List<Object> c;

    public static v a(List<Object> list, List<Object> list2) {
        return new v(true, list, list2);
    }

    public static v a() {
        return new v(false, null, null);
    }

    private v(boolean z, List<Object> list, List<Object> list2) {
        this.a = z;
        this.b = list;
        this.c = list2;
    }
}
