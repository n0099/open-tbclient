package com.baidu.tieba.s;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class d {
    public final List<String> iTU;
    public final String iTV;

    public d(List<String> list, String str) {
        if (list != null) {
            this.iTU = new ArrayList(list);
        } else {
            this.iTU = new ArrayList();
        }
        this.iTV = str;
    }
}
