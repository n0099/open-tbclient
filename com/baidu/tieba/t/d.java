package com.baidu.tieba.t;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class d {
    public final List<String> hDF;
    public final String hDG;

    public d(List<String> list, String str) {
        if (list != null) {
            this.hDF = new ArrayList(list);
        } else {
            this.hDF = new ArrayList();
        }
        this.hDG = str;
    }
}
