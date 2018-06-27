package com.baidu.tieba.t;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d {
    public final List<String> gZX;
    public final String gZY;

    public d(List<String> list, String str) {
        if (list != null) {
            this.gZX = new ArrayList(list);
        } else {
            this.gZX = new ArrayList();
        }
        this.gZY = str;
    }
}
