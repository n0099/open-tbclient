package com.baidu.tieba.view;

import java.util.List;
/* loaded from: classes.dex */
final class j {
    public final boolean a;
    public final List<Object> b;
    public final List<Object> c;

    public static j a(List<Object> list, List<Object> list2) {
        return new j(true, list, list2);
    }

    public static j a() {
        return new j(false, null, null);
    }

    private j(boolean z, List<Object> list, List<Object> list2) {
        this.a = z;
        this.b = list;
        this.c = list2;
    }
}
