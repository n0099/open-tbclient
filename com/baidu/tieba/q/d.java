package com.baidu.tieba.q;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d {
    public final List<String> hmi;
    public final String hmj;

    public d(List<String> list, String str) {
        if (list != null) {
            this.hmi = new ArrayList(list);
        } else {
            this.hmi = new ArrayList();
        }
        this.hmj = str;
    }
}
