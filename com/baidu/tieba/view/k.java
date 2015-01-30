package com.baidu.tieba.view;

import java.util.List;
/* loaded from: classes.dex */
class k {
    public final boolean ajA;
    public final List<Object> ajB;
    public final List<Object> ajC;

    public static k d(List<Object> list, List<Object> list2) {
        return new k(true, list, list2);
    }

    public static k ake() {
        return new k(false, null, null);
    }

    private k(boolean z, List<Object> list, List<Object> list2) {
        this.ajA = z;
        this.ajB = list;
        this.ajC = list2;
    }
}
