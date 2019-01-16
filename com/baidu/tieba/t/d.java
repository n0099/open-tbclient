package com.baidu.tieba.t;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class d {
    public final List<String> hDE;
    public final String hDF;

    public d(List<String> list, String str) {
        if (list != null) {
            this.hDE = new ArrayList(list);
        } else {
            this.hDE = new ArrayList();
        }
        this.hDF = str;
    }
}
