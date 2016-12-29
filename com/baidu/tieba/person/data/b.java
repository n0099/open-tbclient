package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import java.util.List;
/* loaded from: classes.dex */
public class b implements v {
    public static final BdUniqueId eop = BdUniqueId.gen();
    public boolean cfs;
    public String eoq;
    public String eor;
    public String eos;
    public String eot;
    public int eou;
    public List<com.baidu.tieba.personInfo.b> eov;

    public b(boolean z, com.baidu.tieba.personInfo.a aVar) {
        this.cfs = z;
        this.eor = aVar.icon;
        this.eoq = aVar.title;
        this.eos = aVar.booktown;
        this.eot = aVar.tip;
        this.eov = aVar.dKT;
        this.eou = aVar.esI;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eop;
    }
}
