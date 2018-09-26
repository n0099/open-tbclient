package com.baidu.tieba.s;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d {
    public final List<String> hja;
    public final String hjb;

    public d(List<String> list, String str) {
        if (list != null) {
            this.hja = new ArrayList(list);
        } else {
            this.hja = new ArrayList();
        }
        this.hjb = str;
    }
}
