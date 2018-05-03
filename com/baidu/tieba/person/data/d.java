package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements h {
    public static final BdUniqueId fCN = BdUniqueId.gen();
    public boolean dxr;
    public String fCO;
    public String fCP;
    public String fCQ;
    public String fCR;
    public int fCS;
    public List<b> fCT;

    public d(boolean z, a aVar) {
        this.dxr = z;
        this.fCP = aVar.icon;
        this.fCO = aVar.title;
        this.fCQ = aVar.booktown;
        this.fCR = aVar.tip;
        this.fCT = aVar.fCI;
        this.fCS = aVar.fCH;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fCN;
    }
}
