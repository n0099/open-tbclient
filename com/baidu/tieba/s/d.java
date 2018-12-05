package com.baidu.tieba.s;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class d {
    public final List<String> hzm;
    public final String hzn;

    public d(List<String> list, String str) {
        if (list != null) {
            this.hzm = new ArrayList(list);
        } else {
            this.hzm = new ArrayList();
        }
        this.hzn = str;
    }
}
