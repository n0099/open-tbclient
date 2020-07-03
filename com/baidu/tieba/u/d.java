package com.baidu.tieba.u;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class d {
    public final List<String> lTW;
    public final String lTX;

    public d(List<String> list, String str) {
        if (list != null) {
            this.lTW = new ArrayList(list);
        } else {
            this.lTW = new ArrayList();
        }
        this.lTX = str;
    }
}
