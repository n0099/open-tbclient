package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import java.util.List;
/* loaded from: classes16.dex */
public class d implements q {
    public static final BdUniqueId kNO = BdUniqueId.gen();
    public boolean fVs;
    public String kNP;
    public String kNQ;
    public String kNR;
    public String kNS;
    public int kNT;
    public List<b> kNU;

    public d(boolean z, a aVar) {
        this.fVs = z;
        this.kNQ = aVar.icon;
        this.kNP = aVar.title;
        this.kNR = aVar.booktown;
        this.kNS = aVar.tip;
        this.kNU = aVar.kNH;
        this.kNT = aVar.kNG;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kNO;
    }
}
