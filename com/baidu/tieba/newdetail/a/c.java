package com.baidu.tieba.newdetail.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
/* loaded from: classes8.dex */
public class c implements n {
    public boolean lml = true;
    public String title;

    public c(String str) {
        this.title = str;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return a.lyO;
    }
}
