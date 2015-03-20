package com.baidu.tieba.view;

import java.util.List;
/* loaded from: classes.dex */
class d {
    public final boolean arW;
    public final List<Object> arX;
    public final List<Object> arY;

    public static d e(List<Object> list, List<Object> list2) {
        return new d(true, list, list2);
    }

    public static d apu() {
        return new d(false, null, null);
    }

    private d(boolean z, List<Object> list, List<Object> list2) {
        this.arW = z;
        this.arX = list;
        this.arY = list2;
    }
}
