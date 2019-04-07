package com.baidu.tieba.s;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class d {
    public final List<String> iTT;
    public final String iTU;

    public d(List<String> list, String str) {
        if (list != null) {
            this.iTT = new ArrayList(list);
        } else {
            this.iTT = new ArrayList();
        }
        this.iTU = str;
    }
}
