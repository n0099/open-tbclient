package com.baidu.tieba.monitor.b;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a {
    public final List<String> exF;
    public final String exG;

    public a(List<String> list, String str) {
        if (list != null) {
            this.exF = new ArrayList(list);
        } else {
            this.exF = new ArrayList();
        }
        this.exG = str;
    }
}
