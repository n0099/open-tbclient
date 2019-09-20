package com.baidu.tieba.s;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class d {
    public final List<String> jwG;
    public final String jwH;

    public d(List<String> list, String str) {
        if (list != null) {
            this.jwG = new ArrayList(list);
        } else {
            this.jwG = new ArrayList();
        }
        this.jwH = str;
    }
}
