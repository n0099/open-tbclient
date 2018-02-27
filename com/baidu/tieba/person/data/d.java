package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
import java.util.List;
/* loaded from: classes.dex */
public class d implements i {
    public static final BdUniqueId gic = BdUniqueId.gen();
    public boolean ecy;
    public String gie;
    public String gif;
    public String gig;
    public String gih;
    public int gii;
    public List<b> gij;

    public d(boolean z, a aVar) {
        this.ecy = z;
        this.gif = aVar.icon;
        this.gie = aVar.title;
        this.gig = aVar.booktown;
        this.gih = aVar.tip;
        this.gij = aVar.ghX;
        this.gii = aVar.ghW;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gic;
    }
}
