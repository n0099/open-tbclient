package com.baidu.tieba.view;

import java.util.List;
/* loaded from: classes.dex */
class h {
    public final boolean abg;
    public final List<Object> abh;
    public final List<Object> abi;

    public static h b(List<Object> list, List<Object> list2) {
        return new h(true, list, list2);
    }

    public static h aeP() {
        return new h(false, null, null);
    }

    private h(boolean z, List<Object> list, List<Object> list2) {
        this.abg = z;
        this.abh = list;
        this.abi = list2;
    }
}
