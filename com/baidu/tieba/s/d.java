package com.baidu.tieba.s;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d {
    public final List<String> hbi;
    public final String hbj;

    public d(List<String> list, String str) {
        if (list != null) {
            this.hbi = new ArrayList(list);
        } else {
            this.hbi = new ArrayList();
        }
        this.hbj = str;
    }
}
