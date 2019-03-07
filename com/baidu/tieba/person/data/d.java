package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.List;
/* loaded from: classes4.dex */
public class d implements m {
    public static final BdUniqueId hKK = BdUniqueId.gen();
    public boolean fDg;
    public String hKL;
    public String hKM;
    public String hKN;
    public String hKO;
    public int hKP;
    public List<b> hKQ;

    public d(boolean z, a aVar) {
        this.fDg = z;
        this.hKM = aVar.icon;
        this.hKL = aVar.title;
        this.hKN = aVar.booktown;
        this.hKO = aVar.tip;
        this.hKQ = aVar.hKD;
        this.hKP = aVar.hKC;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hKK;
    }
}
