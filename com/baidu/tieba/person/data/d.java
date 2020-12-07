package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import java.util.List;
/* loaded from: classes22.dex */
public class d implements q {
    public static final BdUniqueId miO = BdUniqueId.gen();
    public boolean gZr;
    public String miP;
    public String miQ;
    public String miR;
    public String miS;
    public int miT;
    public List<b> miU;

    public d(boolean z, a aVar) {
        this.gZr = z;
        this.miQ = aVar.icon;
        this.miP = aVar.title;
        this.miR = aVar.booktown;
        this.miS = aVar.tip;
        this.miU = aVar.miH;
        this.miT = aVar.miG;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return miO;
    }
}
