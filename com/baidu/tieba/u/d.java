package com.baidu.tieba.u;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes17.dex */
public class d {
    public final List<String> mbr;
    public final String mbs;

    public d(List<String> list, String str) {
        if (list != null) {
            this.mbr = new ArrayList(list);
        } else {
            this.mbr = new ArrayList();
        }
        this.mbs = str;
    }
}
