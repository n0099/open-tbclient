package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
import java.util.List;
/* loaded from: classes.dex */
public class b implements f {
    public static final BdUniqueId fgi = BdUniqueId.gen();
    public boolean cJK;
    public String fgj;
    public String fgk;
    public String fgl;
    public String fgm;
    public int fgn;
    public List<com.baidu.tieba.personInfo.b> fgo;

    public b(boolean z, com.baidu.tieba.personInfo.a aVar) {
        this.cJK = z;
        this.fgk = aVar.icon;
        this.fgj = aVar.title;
        this.fgl = aVar.booktown;
        this.fgm = aVar.tip;
        this.fgo = aVar.etP;
        this.fgn = aVar.fjV;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fgi;
    }
}
