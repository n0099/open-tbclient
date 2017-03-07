package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import java.util.List;
/* loaded from: classes.dex */
public class b implements v {
    public static final BdUniqueId eBI = BdUniqueId.gen();
    public boolean cnh;
    public String eBJ;
    public String eBK;
    public String eBL;
    public String eBM;
    public int eBN;
    public List<com.baidu.tieba.personInfo.b> eBO;

    public b(boolean z, com.baidu.tieba.personInfo.a aVar) {
        this.cnh = z;
        this.eBK = aVar.icon;
        this.eBJ = aVar.title;
        this.eBL = aVar.booktown;
        this.eBM = aVar.tip;
        this.eBO = aVar.dWK;
        this.eBN = aVar.eGf;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eBI;
    }
}
