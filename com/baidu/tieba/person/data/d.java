package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
import java.util.List;
/* loaded from: classes.dex */
public class d implements i {
    public static final BdUniqueId ggm = BdUniqueId.gen();
    public boolean dYd;
    public String ggn;
    public String ggo;
    public String ggp;
    public String ggq;
    public int ggr;
    public List<b> ggs;

    public d(boolean z, a aVar) {
        this.dYd = z;
        this.ggo = aVar.icon;
        this.ggn = aVar.title;
        this.ggp = aVar.booktown;
        this.ggq = aVar.tip;
        this.ggs = aVar.ggh;
        this.ggr = aVar.ggg;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return ggm;
    }
}
