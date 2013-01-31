package com.baidu.tieba.view;

import java.util.List;
/* loaded from: classes.dex */
class e {
    public final boolean a;
    public final List b;
    public final List c;

    public static e a(List list, List list2) {
        return new e(true, list, list2);
    }

    public static e a() {
        return new e(false, null, null);
    }

    private e(boolean z, List list, List list2) {
        this.a = z;
        this.b = list;
        this.c = list2;
    }
}
