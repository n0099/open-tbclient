package com.baidu.tieba.monitor.c;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a {
    public final List<String> exZ;
    public final String eya;

    public a(List<String> list, String str) {
        if (list != null) {
            this.exZ = new ArrayList(list);
        } else {
            this.exZ = new ArrayList();
        }
        this.eya = str;
    }
}
