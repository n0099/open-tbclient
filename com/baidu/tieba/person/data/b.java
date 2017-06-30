package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import java.util.List;
/* loaded from: classes.dex */
public class b implements v {
    public static final BdUniqueId eQD = BdUniqueId.gen();
    public boolean czh;
    public String eQE;
    public String eQF;
    public String eQG;
    public String eQH;
    public int eQI;
    public List<com.baidu.tieba.personInfo.b> eQJ;

    public b(boolean z, com.baidu.tieba.personInfo.a aVar) {
        this.czh = z;
        this.eQF = aVar.icon;
        this.eQE = aVar.title;
        this.eQG = aVar.booktown;
        this.eQH = aVar.tip;
        this.eQJ = aVar.eft;
        this.eQI = aVar.eUp;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eQD;
    }
}
