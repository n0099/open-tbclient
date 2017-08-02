package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
import java.util.List;
/* loaded from: classes.dex */
public class b implements f {
    public static final BdUniqueId fdd = BdUniqueId.gen();
    public boolean cGs;
    public String fde;
    public String fdf;
    public String fdg;
    public String fdh;
    public int fdi;
    public List<com.baidu.tieba.personInfo.b> fdj;

    public b(boolean z, com.baidu.tieba.personInfo.a aVar) {
        this.cGs = z;
        this.fdf = aVar.icon;
        this.fde = aVar.title;
        this.fdg = aVar.booktown;
        this.fdh = aVar.tip;
        this.fdj = aVar.eqD;
        this.fdi = aVar.fgO;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fdd;
    }
}
