package com.baidu.tieba.s;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class d {
    public final List<String> hqr;
    public final String hqs;

    public d(List<String> list, String str) {
        if (list != null) {
            this.hqr = new ArrayList(list);
        } else {
            this.hqr = new ArrayList();
        }
        this.hqs = str;
    }
}
