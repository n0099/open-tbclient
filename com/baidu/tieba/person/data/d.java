package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
import java.util.List;
/* loaded from: classes.dex */
public class d implements i {
    public static final BdUniqueId ggF = BdUniqueId.gen();
    public boolean dYy;
    public String ggG;
    public String ggH;
    public String ggI;
    public String ggJ;
    public int ggK;
    public List<b> ggL;

    public d(boolean z, a aVar) {
        this.dYy = z;
        this.ggH = aVar.icon;
        this.ggG = aVar.title;
        this.ggI = aVar.booktown;
        this.ggJ = aVar.tip;
        this.ggL = aVar.ggA;
        this.ggK = aVar.ggz;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return ggF;
    }
}
