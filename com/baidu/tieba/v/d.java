package com.baidu.tieba.v;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public class d {
    public final List<String> nmw;
    public final String nmx;

    public d(List<String> list, String str) {
        if (list != null) {
            this.nmw = new ArrayList(list);
        } else {
            this.nmw = new ArrayList();
        }
        this.nmx = str;
    }
}
