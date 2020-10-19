package com.baidu.tieba.u;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes23.dex */
public class d {
    public final List<String> mSQ;
    public final String mSR;

    public d(List<String> list, String str) {
        if (list != null) {
            this.mSQ = new ArrayList(list);
        } else {
            this.mSQ = new ArrayList();
        }
        this.mSR = str;
    }
}
