package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import java.util.List;
/* loaded from: classes.dex */
public class b implements v {
    public static final BdUniqueId eBY = BdUniqueId.gen();
    public boolean cuz;
    public String eBZ;
    public String eCa;
    public String eCb;
    public String eCc;
    public int eCd;
    public List<com.baidu.tieba.personInfo.b> eCe;

    public b(boolean z, com.baidu.tieba.personInfo.a aVar) {
        this.cuz = z;
        this.eCa = aVar.icon;
        this.eBZ = aVar.title;
        this.eCb = aVar.booktown;
        this.eCc = aVar.tip;
        this.eCe = aVar.dYs;
        this.eCd = aVar.eGJ;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eBY;
    }
}
