package com.baidu.tieba.s;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class d {
    public final List<String> hsa;
    public final String hsb;

    public d(List<String> list, String str) {
        if (list != null) {
            this.hsa = new ArrayList(list);
        } else {
            this.hsa = new ArrayList();
        }
        this.hsb = str;
    }
}
