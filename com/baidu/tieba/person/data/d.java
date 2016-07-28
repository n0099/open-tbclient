package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import java.util.List;
/* loaded from: classes.dex */
public class d implements v {
    public static final BdUniqueId erO = BdUniqueId.gen();
    public boolean cjo;
    public String erP;
    public String erQ;
    public String erR;
    public String erS;
    public int erT;
    public List<com.baidu.tieba.personInfo.c> erU;

    public d(boolean z, com.baidu.tieba.personInfo.b bVar) {
        this.cjo = z;
        this.erQ = bVar.icon;
        this.erP = bVar.title;
        this.erR = bVar.booktown;
        this.erS = bVar.tip;
        this.erU = bVar.dMn;
        this.erT = bVar.eAf;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return erO;
    }
}
