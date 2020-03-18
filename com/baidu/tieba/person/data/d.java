package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.List;
/* loaded from: classes9.dex */
public class d implements m {
    public static final BdUniqueId jhP = BdUniqueId.gen();
    public boolean eMo;
    public String jhQ;
    public String jhR;
    public String jhS;
    public String jhT;
    public int jhU;
    public List<b> jhV;

    public d(boolean z, a aVar) {
        this.eMo = z;
        this.jhR = aVar.icon;
        this.jhQ = aVar.title;
        this.jhS = aVar.booktown;
        this.jhT = aVar.tip;
        this.jhV = aVar.jhI;
        this.jhU = aVar.jhH;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jhP;
    }
}
