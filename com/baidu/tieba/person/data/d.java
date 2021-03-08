package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements n {
    public static final BdUniqueId muM = BdUniqueId.gen();
    public boolean hmO;
    public String muN;
    public String muO;
    public String muP;
    public String muQ;
    public int muR;
    public List<b> muS;

    public d(boolean z, a aVar) {
        this.hmO = z;
        this.muO = aVar.icon;
        this.muN = aVar.title;
        this.muP = aVar.booktown;
        this.muQ = aVar.tip;
        this.muS = aVar.muF;
        this.muR = aVar.muE;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return muM;
    }
}
