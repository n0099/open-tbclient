package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import java.util.List;
/* loaded from: classes21.dex */
public class d implements q {
    public static final BdUniqueId lmE = BdUniqueId.gen();
    public boolean gkE;
    public String lmF;
    public String lmG;
    public String lmH;
    public String lmI;
    public int lmJ;
    public List<b> lmK;

    public d(boolean z, a aVar) {
        this.gkE = z;
        this.lmG = aVar.icon;
        this.lmF = aVar.title;
        this.lmH = aVar.booktown;
        this.lmI = aVar.tip;
        this.lmK = aVar.lmx;
        this.lmJ = aVar.lmw;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lmE;
    }
}
