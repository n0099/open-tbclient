package com.baidu.tieba.newdetail.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes15.dex */
public class c implements q {
    public boolean jJU = true;
    public String title;

    public c(String str) {
        this.title = str;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return a.jWF;
    }
}
