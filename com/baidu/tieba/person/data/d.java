package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.List;
/* loaded from: classes9.dex */
public class d implements m {
    public static final BdUniqueId jRX = BdUniqueId.gen();
    public boolean fqG;
    public String jRY;
    public String jRZ;
    public String jSa;
    public String jSb;
    public int jSc;
    public List<b> jSd;

    public d(boolean z, a aVar) {
        this.fqG = z;
        this.jRZ = aVar.icon;
        this.jRY = aVar.title;
        this.jSa = aVar.booktown;
        this.jSb = aVar.tip;
        this.jSd = aVar.jRQ;
        this.jSc = aVar.jRP;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jRX;
    }
}
