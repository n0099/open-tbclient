package com.baidu.tieba.s;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class d {
    public final List<String> juk;
    public final String jul;

    public d(List<String> list, String str) {
        if (list != null) {
            this.juk = new ArrayList(list);
        } else {
            this.juk = new ArrayList();
        }
        this.jul = str;
    }
}
