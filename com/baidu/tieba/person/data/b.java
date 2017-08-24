package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
import java.util.List;
/* loaded from: classes.dex */
public class b implements f {
    public static final BdUniqueId fgk = BdUniqueId.gen();
    public boolean cJK;
    public String fgl;
    public String fgm;
    public String fgn;
    public String fgo;
    public int fgp;
    public List<com.baidu.tieba.personInfo.b> fgq;

    public b(boolean z, com.baidu.tieba.personInfo.a aVar) {
        this.cJK = z;
        this.fgm = aVar.icon;
        this.fgl = aVar.title;
        this.fgn = aVar.booktown;
        this.fgo = aVar.tip;
        this.fgq = aVar.etR;
        this.fgp = aVar.fjX;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fgk;
    }
}
