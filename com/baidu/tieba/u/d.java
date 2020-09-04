package com.baidu.tieba.u;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes17.dex */
public class d {
    public final List<String> mtu;
    public final String mtv;

    public d(List<String> list, String str) {
        if (list != null) {
            this.mtu = new ArrayList(list);
        } else {
            this.mtu = new ArrayList();
        }
        this.mtv = str;
    }
}
