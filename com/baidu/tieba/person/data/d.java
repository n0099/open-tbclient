package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.List;
/* loaded from: classes9.dex */
public class d implements m {
    public static final BdUniqueId jgq = BdUniqueId.gen();
    public boolean eLS;
    public String jgr;
    public String jgs;
    public String jgt;
    public String jgu;
    public int jgv;
    public List<b> jgw;

    public d(boolean z, a aVar) {
        this.eLS = z;
        this.jgs = aVar.icon;
        this.jgr = aVar.title;
        this.jgt = aVar.booktown;
        this.jgu = aVar.tip;
        this.jgw = aVar.jgj;
        this.jgv = aVar.jgi;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jgq;
    }
}
