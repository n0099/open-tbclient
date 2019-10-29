package com.baidu.tieba.s;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class d {
    public final List<String> jwx;
    public final String jwy;

    public d(List<String> list, String str) {
        if (list != null) {
            this.jwx = new ArrayList(list);
        } else {
            this.jwx = new ArrayList();
        }
        this.jwy = str;
    }
}
