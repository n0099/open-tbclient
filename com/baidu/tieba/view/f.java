package com.baidu.tieba.view;

import java.util.List;
/* loaded from: classes.dex */
class f {
    public final boolean aiX;
    public final List<Object> aiY;
    public final List<Object> aiZ;

    public static f d(List<Object> list, List<Object> list2) {
        return new f(true, list, list2);
    }

    public static f ajH() {
        return new f(false, null, null);
    }

    private f(boolean z, List<Object> list, List<Object> list2) {
        this.aiX = z;
        this.aiY = list;
        this.aiZ = list2;
    }
}
