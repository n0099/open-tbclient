package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.List;
/* loaded from: classes4.dex */
public class d implements m {
    public static final BdUniqueId hKL = BdUniqueId.gen();
    public boolean fDg;
    public String hKM;
    public String hKN;
    public String hKO;
    public String hKP;
    public int hKQ;
    public List<b> hKR;

    public d(boolean z, a aVar) {
        this.fDg = z;
        this.hKN = aVar.icon;
        this.hKM = aVar.title;
        this.hKO = aVar.booktown;
        this.hKP = aVar.tip;
        this.hKR = aVar.hKE;
        this.hKQ = aVar.hKD;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hKL;
    }
}
