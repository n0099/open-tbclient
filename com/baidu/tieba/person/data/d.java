package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.List;
/* loaded from: classes4.dex */
public class d implements m {
    public static final BdUniqueId ilO = BdUniqueId.gen();
    public boolean gbx;
    public String ilP;
    public String ilQ;
    public String ilR;
    public String ilS;
    public int ilT;
    public List<b> ilU;

    public d(boolean z, a aVar) {
        this.gbx = z;
        this.ilQ = aVar.icon;
        this.ilP = aVar.title;
        this.ilR = aVar.booktown;
        this.ilS = aVar.tip;
        this.ilU = aVar.ilH;
        this.ilT = aVar.ilG;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ilO;
    }
}
