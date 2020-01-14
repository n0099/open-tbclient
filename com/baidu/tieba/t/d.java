package com.baidu.tieba.t;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class d {
    public final List<String> ktw;
    public final String ktx;

    public d(List<String> list, String str) {
        if (list != null) {
            this.ktw = new ArrayList(list);
        } else {
            this.ktw = new ArrayList();
        }
        this.ktx = str;
    }
}
