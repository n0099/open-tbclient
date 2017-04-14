package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import java.util.List;
/* loaded from: classes.dex */
public class b implements v {
    public static final BdUniqueId ezO = BdUniqueId.gen();
    public boolean clG;
    public String ezP;
    public String ezQ;
    public String ezR;
    public String ezS;
    public int ezT;
    public List<com.baidu.tieba.personInfo.b> ezU;

    public b(boolean z, com.baidu.tieba.personInfo.a aVar) {
        this.clG = z;
        this.ezQ = aVar.icon;
        this.ezP = aVar.title;
        this.ezR = aVar.booktown;
        this.ezS = aVar.tip;
        this.ezU = aVar.dUd;
        this.ezT = aVar.eEb;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return ezO;
    }
}
