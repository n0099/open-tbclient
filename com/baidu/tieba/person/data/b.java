package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import java.util.List;
/* loaded from: classes.dex */
public class b implements v {
    public static final BdUniqueId eKA = BdUniqueId.gen();
    public boolean cAf;
    public String eKB;
    public String eKC;
    public String eKD;
    public String eKE;
    public int eKF;
    public List<com.baidu.tieba.personInfo.b> eKG;

    public b(boolean z, com.baidu.tieba.personInfo.a aVar) {
        this.cAf = z;
        this.eKC = aVar.icon;
        this.eKB = aVar.title;
        this.eKD = aVar.booktown;
        this.eKE = aVar.tip;
        this.eKG = aVar.egm;
        this.eKF = aVar.ePm;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eKA;
    }
}
