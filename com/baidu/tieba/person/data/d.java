package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class d implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId eZg = BdUniqueId.gen();
    public boolean cRI;
    public String eZh;
    public String eZi;
    public String eZj;
    public String eZk;
    public int eZl;
    public List<b> eZm;

    public d(boolean z, a aVar) {
        this.cRI = z;
        this.eZi = aVar.icon;
        this.eZh = aVar.title;
        this.eZj = aVar.booktown;
        this.eZk = aVar.tip;
        this.eZm = aVar.eZb;
        this.eZl = aVar.eZa;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return eZg;
    }
}
