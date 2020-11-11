package com.baidu.tieba.u;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes23.dex */
public class d {
    public final List<String> nlp;
    public final String nlq;

    public d(List<String> list, String str) {
        if (list != null) {
            this.nlp = new ArrayList(list);
        } else {
            this.nlp = new ArrayList();
        }
        this.nlq = str;
    }
}
