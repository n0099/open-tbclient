package com.baidu.tieba.q;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d {
    public final List<String> hlO;
    public final String hlP;

    public d(List<String> list, String str) {
        if (list != null) {
            this.hlO = new ArrayList(list);
        } else {
            this.hlO = new ArrayList();
        }
        this.hlP = str;
    }
}
