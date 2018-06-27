package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements h {
    public static final BdUniqueId fTp = BdUniqueId.gen();
    public boolean dNa;
    public String fTq;
    public String fTr;
    public String fTs;
    public String fTt;
    public int fTu;
    public List<b> fTv;

    public d(boolean z, a aVar) {
        this.dNa = z;
        this.fTr = aVar.icon;
        this.fTq = aVar.title;
        this.fTs = aVar.booktown;
        this.fTt = aVar.tip;
        this.fTv = aVar.fTk;
        this.fTu = aVar.fTj;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fTp;
    }
}
