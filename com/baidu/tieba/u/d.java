package com.baidu.tieba.u;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class d {
    public final List<String> nAd;
    public final String nAe;

    public d(List<String> list, String str) {
        if (list != null) {
            this.nAd = new ArrayList(list);
        } else {
            this.nAd = new ArrayList();
        }
        this.nAe = str;
    }
}
