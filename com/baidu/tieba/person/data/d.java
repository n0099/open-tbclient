package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.List;
/* loaded from: classes4.dex */
public class d implements m {
    public static final BdUniqueId hKF = BdUniqueId.gen();
    public boolean fDf;
    public String hKG;
    public String hKH;
    public String hKI;
    public String hKJ;
    public int hKK;
    public List<b> hKL;

    public d(boolean z, a aVar) {
        this.fDf = z;
        this.hKH = aVar.icon;
        this.hKG = aVar.title;
        this.hKI = aVar.booktown;
        this.hKJ = aVar.tip;
        this.hKL = aVar.hKy;
        this.hKK = aVar.hKx;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hKF;
    }
}
