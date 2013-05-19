package com.baidu.tieba.view;

import java.util.List;
/* loaded from: classes.dex */
class f {
    public final boolean a;
    public final List b;
    public final List c;

    public static f a(List list, List list2) {
        return new f(true, list, list2);
    }

    public static f a() {
        return new f(false, null, null);
    }

    private f(boolean z, List list, List list2) {
        this.a = z;
        this.b = list;
        this.c = list2;
    }
}
