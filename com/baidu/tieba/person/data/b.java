package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import java.util.List;
/* loaded from: classes.dex */
public class b implements v {
    public static final BdUniqueId eGO = BdUniqueId.gen();
    public boolean crt;
    public String eGP;
    public String eGQ;
    public String eGR;
    public String eGS;
    public int eGT;
    public List<com.baidu.tieba.personInfo.b> eGU;

    public b(boolean z, com.baidu.tieba.personInfo.a aVar) {
        this.crt = z;
        this.eGQ = aVar.icon;
        this.eGP = aVar.title;
        this.eGR = aVar.booktown;
        this.eGS = aVar.tip;
        this.eGU = aVar.dWx;
        this.eGT = aVar.eKr;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eGO;
    }
}
