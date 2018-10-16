package com.baidu.tieba.s;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class d {
    public final List<String> hqq;
    public final String hqr;

    public d(List<String> list, String str) {
        if (list != null) {
            this.hqq = new ArrayList(list);
        } else {
            this.hqq = new ArrayList();
        }
        this.hqr = str;
    }
}
