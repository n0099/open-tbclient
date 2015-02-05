package com.baidu.tieba.view;

import java.util.List;
/* loaded from: classes.dex */
class k {
    public final boolean ajx;
    public final List<Object> ajy;
    public final List<Object> ajz;

    public static k d(List<Object> list, List<Object> list2) {
        return new k(true, list, list2);
    }

    public static k ajZ() {
        return new k(false, null, null);
    }

    private k(boolean z, List<Object> list, List<Object> list2) {
        this.ajx = z;
        this.ajy = list;
        this.ajz = list2;
    }
}
