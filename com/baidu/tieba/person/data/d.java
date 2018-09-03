package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements h {
    public static final BdUniqueId fTu = BdUniqueId.gen();
    public boolean dPJ;
    public List<b> fTA;
    public String fTv;
    public String fTw;
    public String fTx;
    public String fTy;
    public int fTz;

    public d(boolean z, a aVar) {
        this.dPJ = z;
        this.fTw = aVar.icon;
        this.fTv = aVar.title;
        this.fTx = aVar.booktown;
        this.fTy = aVar.tip;
        this.fTA = aVar.fTn;
        this.fTz = aVar.fTm;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fTu;
    }
}
