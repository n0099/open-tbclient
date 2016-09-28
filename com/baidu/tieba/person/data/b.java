package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import java.util.List;
/* loaded from: classes.dex */
public class b implements v {
    public static final BdUniqueId eEb = BdUniqueId.gen();
    public boolean cuW;
    public String eEc;
    public String eEd;
    public String eEe;
    public String eEf;
    public int eEg;
    public List<com.baidu.tieba.personInfo.b> eEh;

    public b(boolean z, com.baidu.tieba.personInfo.a aVar) {
        this.cuW = z;
        this.eEd = aVar.icon;
        this.eEc = aVar.title;
        this.eEe = aVar.booktown;
        this.eEf = aVar.tip;
        this.eEh = aVar.ean;
        this.eEg = aVar.eIN;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eEb;
    }
}
