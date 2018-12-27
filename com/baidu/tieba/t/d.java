package com.baidu.tieba.t;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class d {
    public final List<String> hCx;
    public final String hCy;

    public d(List<String> list, String str) {
        if (list != null) {
            this.hCx = new ArrayList(list);
        } else {
            this.hCx = new ArrayList();
        }
        this.hCy = str;
    }
}
