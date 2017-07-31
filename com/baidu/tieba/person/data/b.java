package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
import java.util.List;
/* loaded from: classes.dex */
public class b implements f {
    public static final BdUniqueId fep = BdUniqueId.gen();
    public boolean cHN;
    public String feq;
    public String fer;
    public String fes;
    public String fet;
    public int feu;
    public List<com.baidu.tieba.personInfo.b> fev;

    public b(boolean z, com.baidu.tieba.personInfo.a aVar) {
        this.cHN = z;
        this.fer = aVar.icon;
        this.feq = aVar.title;
        this.fes = aVar.booktown;
        this.fet = aVar.tip;
        this.fev = aVar.erU;
        this.feu = aVar.fia;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fep;
    }
}
