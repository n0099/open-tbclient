package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.List;
/* loaded from: classes4.dex */
public class d implements m {
    public static final BdUniqueId iiN = BdUniqueId.gen();
    public boolean fYQ;
    public String iiO;
    public String iiP;
    public String iiQ;
    public String iiR;
    public int iiS;
    public List<b> iiT;

    public d(boolean z, a aVar) {
        this.fYQ = z;
        this.iiP = aVar.icon;
        this.iiO = aVar.title;
        this.iiQ = aVar.booktown;
        this.iiR = aVar.tip;
        this.iiT = aVar.iiG;
        this.iiS = aVar.iiF;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iiN;
    }
}
