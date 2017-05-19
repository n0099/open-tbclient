package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import java.util.List;
/* loaded from: classes.dex */
public class b implements v {
    public static final BdUniqueId exW = BdUniqueId.gen();
    public boolean ckU;
    public String exX;
    public String exY;
    public String exZ;
    public String eya;
    public int eyb;
    public List<com.baidu.tieba.personInfo.b> eyc;

    public b(boolean z, com.baidu.tieba.personInfo.a aVar) {
        this.ckU = z;
        this.exY = aVar.icon;
        this.exX = aVar.title;
        this.exZ = aVar.booktown;
        this.eya = aVar.tip;
        this.eyc = aVar.dRc;
        this.eyb = aVar.eBF;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return exW;
    }
}
