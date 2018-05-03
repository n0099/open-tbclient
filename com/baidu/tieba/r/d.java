package com.baidu.tieba.r;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d {
    public final List<String> gJn;
    public final String gJo;

    public d(List<String> list, String str) {
        if (list != null) {
            this.gJn = new ArrayList(list);
        } else {
            this.gJn = new ArrayList();
        }
        this.gJo = str;
    }
}
