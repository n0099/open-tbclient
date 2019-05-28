package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.List;
/* loaded from: classes4.dex */
public class d implements m {
    public static final BdUniqueId icu = BdUniqueId.gen();
    public boolean fTR;
    public List<b> icA;
    public String icv;
    public String icw;
    public String icx;
    public String icy;
    public int icz;

    public d(boolean z, a aVar) {
        this.fTR = z;
        this.icw = aVar.icon;
        this.icv = aVar.title;
        this.icx = aVar.booktown;
        this.icy = aVar.tip;
        this.icA = aVar.icn;
        this.icz = aVar.icm;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return icu;
    }
}
