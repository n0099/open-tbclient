package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements h {
    public static final BdUniqueId fDT = BdUniqueId.gen();
    public boolean dyy;
    public String fDU;
    public String fDV;
    public String fDW;
    public String fDX;
    public int fDY;
    public List<b> fDZ;

    public d(boolean z, a aVar) {
        this.dyy = z;
        this.fDV = aVar.icon;
        this.fDU = aVar.title;
        this.fDW = aVar.booktown;
        this.fDX = aVar.tip;
        this.fDZ = aVar.fDO;
        this.fDY = aVar.fDN;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fDT;
    }
}
