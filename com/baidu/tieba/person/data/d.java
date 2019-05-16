package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.List;
/* loaded from: classes4.dex */
public class d implements m {
    public static final BdUniqueId icr = BdUniqueId.gen();
    public boolean fTQ;
    public String ics;
    public String ict;
    public String icu;
    public String icv;
    public int icw;
    public List<b> icx;

    public d(boolean z, a aVar) {
        this.fTQ = z;
        this.ict = aVar.icon;
        this.ics = aVar.title;
        this.icu = aVar.booktown;
        this.icv = aVar.tip;
        this.icx = aVar.ick;
        this.icw = aVar.icj;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return icr;
    }
}
