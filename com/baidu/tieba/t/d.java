package com.baidu.tieba.t;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class d {
    public final List<String> kpO;
    public final String kpP;

    public d(List<String> list, String str) {
        if (list != null) {
            this.kpO = new ArrayList(list);
        } else {
            this.kpO = new ArrayList();
        }
        this.kpP = str;
    }
}
