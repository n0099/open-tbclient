package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import java.util.List;
/* loaded from: classes16.dex */
public class d implements q {
    public static final BdUniqueId kNQ = BdUniqueId.gen();
    public boolean fVs;
    public String kNR;
    public String kNS;
    public String kNT;
    public String kNU;
    public int kNV;
    public List<b> kNW;

    public d(boolean z, a aVar) {
        this.fVs = z;
        this.kNS = aVar.icon;
        this.kNR = aVar.title;
        this.kNT = aVar.booktown;
        this.kNU = aVar.tip;
        this.kNW = aVar.kNJ;
        this.kNV = aVar.kNI;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kNQ;
    }
}
