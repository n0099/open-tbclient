package com.baidu.tieba.view;

import java.util.List;
/* loaded from: classes.dex */
class h {
    public final boolean abl;
    public final List<Object> abm;
    public final List<Object> abn;

    public static h b(List<Object> list, List<Object> list2) {
        return new h(true, list, list2);
    }

    public static h aeS() {
        return new h(false, null, null);
    }

    private h(boolean z, List<Object> list, List<Object> list2) {
        this.abl = z;
        this.abm = list;
        this.abn = list2;
    }
}
