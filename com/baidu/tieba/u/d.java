package com.baidu.tieba.u;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes23.dex */
public class d {
    public final List<String> nft;
    public final String nfu;

    public d(List<String> list, String str) {
        if (list != null) {
            this.nft = new ArrayList(list);
        } else {
            this.nft = new ArrayList();
        }
        this.nfu = str;
    }
}
