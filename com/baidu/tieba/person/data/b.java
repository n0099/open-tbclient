package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import java.util.List;
/* loaded from: classes.dex */
public class b implements v {
    public static final BdUniqueId eyi = BdUniqueId.gen();
    public boolean clJ;
    public String eyj;
    public String eyk;
    public String eyl;
    public String eyn;
    public int eyo;
    public List<com.baidu.tieba.personInfo.b> eyp;

    public b(boolean z, com.baidu.tieba.personInfo.a aVar) {
        this.clJ = z;
        this.eyk = aVar.icon;
        this.eyj = aVar.title;
        this.eyl = aVar.booktown;
        this.eyn = aVar.tip;
        this.eyp = aVar.dTQ;
        this.eyo = aVar.eCD;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eyi;
    }
}
