package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class d implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId eZu = BdUniqueId.gen();
    public boolean cRU;
    public List<b> eZA;
    public String eZv;
    public String eZw;
    public String eZx;
    public String eZy;
    public int eZz;

    public d(boolean z, a aVar) {
        this.cRU = z;
        this.eZw = aVar.icon;
        this.eZv = aVar.title;
        this.eZx = aVar.booktown;
        this.eZy = aVar.tip;
        this.eZA = aVar.eZp;
        this.eZz = aVar.eZo;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return eZu;
    }
}
