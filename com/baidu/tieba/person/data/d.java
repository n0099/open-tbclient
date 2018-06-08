package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements h {
    public static final BdUniqueId fPn = BdUniqueId.gen();
    public boolean dJI;
    public String fPo;
    public String fPp;
    public String fPq;
    public String fPr;
    public int fPs;
    public List<b> fPt;

    public d(boolean z, a aVar) {
        this.dJI = z;
        this.fPp = aVar.icon;
        this.fPo = aVar.title;
        this.fPq = aVar.booktown;
        this.fPr = aVar.tip;
        this.fPt = aVar.fPi;
        this.fPs = aVar.fPh;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fPn;
    }
}
