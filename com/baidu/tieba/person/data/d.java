package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.List;
/* loaded from: classes4.dex */
public class d implements m {
    public static final BdUniqueId icv = BdUniqueId.gen();
    public boolean fTT;
    public int icA;
    public List<b> icB;
    public String icw;
    public String icx;
    public String icy;
    public String icz;

    public d(boolean z, a aVar) {
        this.fTT = z;
        this.icx = aVar.icon;
        this.icw = aVar.title;
        this.icy = aVar.booktown;
        this.icz = aVar.tip;
        this.icB = aVar.ico;
        this.icA = aVar.icn;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return icv;
    }
}
