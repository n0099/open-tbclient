package com.baidu.tieba.view;

import java.util.List;
/* loaded from: classes.dex */
class d {
    public final boolean ase;
    public final List<Object> asf;
    public final List<Object> asg;

    public static d e(List<Object> list, List<Object> list2) {
        return new d(true, list, list2);
    }

    public static d apJ() {
        return new d(false, null, null);
    }

    private d(boolean z, List<Object> list, List<Object> list2) {
        this.ase = z;
        this.asf = list;
        this.asg = list2;
    }
}
