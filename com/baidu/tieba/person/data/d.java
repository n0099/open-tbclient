package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.List;
/* loaded from: classes9.dex */
public class d implements m {
    public static final BdUniqueId jSb = BdUniqueId.gen();
    public boolean fqL;
    public String jSc;
    public String jSd;
    public String jSe;
    public String jSf;
    public int jSg;
    public List<b> jSh;

    public d(boolean z, a aVar) {
        this.fqL = z;
        this.jSd = aVar.icon;
        this.jSc = aVar.title;
        this.jSe = aVar.booktown;
        this.jSf = aVar.tip;
        this.jSh = aVar.jRU;
        this.jSg = aVar.jRT;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jSb;
    }
}
