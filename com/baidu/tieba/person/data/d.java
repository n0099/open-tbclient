package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.List;
/* loaded from: classes6.dex */
public class d implements m {
    public static final BdUniqueId jby = BdUniqueId.gen();
    public boolean eGA;
    public String jbA;
    public String jbB;
    public String jbC;
    public int jbD;
    public List<b> jbE;
    public String jbz;

    public d(boolean z, a aVar) {
        this.eGA = z;
        this.jbA = aVar.icon;
        this.jbz = aVar.title;
        this.jbB = aVar.booktown;
        this.jbC = aVar.tip;
        this.jbE = aVar.jbr;
        this.jbD = aVar.jbq;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jby;
    }
}
