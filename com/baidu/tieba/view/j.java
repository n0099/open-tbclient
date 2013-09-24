package com.baidu.tieba.view;

import java.util.List;
/* loaded from: classes.dex */
class j {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1998a;
    public final List<Object> b;
    public final List<Object> c;

    public static j a(List<Object> list, List<Object> list2) {
        return new j(true, list, list2);
    }

    public static j a() {
        return new j(false, null, null);
    }

    private j(boolean z, List<Object> list, List<Object> list2) {
        this.f1998a = z;
        this.b = list;
        this.c = list2;
    }
}
