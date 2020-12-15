package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import java.util.List;
/* loaded from: classes22.dex */
public class d implements q {
    public static final BdUniqueId miQ = BdUniqueId.gen();
    public boolean gZt;
    public String miR;
    public String miS;
    public String miT;
    public String miU;
    public int miV;
    public List<b> miW;

    public d(boolean z, a aVar) {
        this.gZt = z;
        this.miS = aVar.icon;
        this.miR = aVar.title;
        this.miT = aVar.booktown;
        this.miU = aVar.tip;
        this.miW = aVar.miJ;
        this.miV = aVar.miI;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return miQ;
    }
}
