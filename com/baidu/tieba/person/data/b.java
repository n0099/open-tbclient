package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import java.util.List;
/* loaded from: classes.dex */
public class b implements v {
    public static final BdUniqueId eCe = BdUniqueId.gen();
    public boolean cnZ;
    public String eCf;
    public String eCg;
    public String eCh;
    public String eCi;
    public int eCj;
    public List<com.baidu.tieba.personInfo.b> eCk;

    public b(boolean z, com.baidu.tieba.personInfo.a aVar) {
        this.cnZ = z;
        this.eCg = aVar.icon;
        this.eCf = aVar.title;
        this.eCh = aVar.booktown;
        this.eCi = aVar.tip;
        this.eCk = aVar.dWt;
        this.eCj = aVar.eGr;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eCe;
    }
}
