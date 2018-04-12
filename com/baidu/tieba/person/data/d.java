package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements h {
    public static final BdUniqueId fCQ = BdUniqueId.gen();
    public boolean dxu;
    public String fCR;
    public String fCS;
    public String fCT;
    public String fCU;
    public int fCV;
    public List<b> fCW;

    public d(boolean z, a aVar) {
        this.dxu = z;
        this.fCS = aVar.icon;
        this.fCR = aVar.title;
        this.fCT = aVar.booktown;
        this.fCU = aVar.tip;
        this.fCW = aVar.fCL;
        this.fCV = aVar.fCK;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fCQ;
    }
}
