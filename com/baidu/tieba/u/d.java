package com.baidu.tieba.u;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public class d {
    public final List<String> mDd;
    public final String mDe;

    public d(List<String> list, String str) {
        if (list != null) {
            this.mDd = new ArrayList(list);
        } else {
            this.mDd = new ArrayList();
        }
        this.mDe = str;
    }
}
