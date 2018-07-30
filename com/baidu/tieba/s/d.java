package com.baidu.tieba.s;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d {
    public final List<String> hbg;
    public final String hbh;

    public d(List<String> list, String str) {
        if (list != null) {
            this.hbg = new ArrayList(list);
        } else {
            this.hbg = new ArrayList();
        }
        this.hbh = str;
    }
}
