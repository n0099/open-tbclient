package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.List;
/* loaded from: classes4.dex */
public class d implements m {
    public static final BdUniqueId hKr = BdUniqueId.gen();
    public boolean fCT;
    public String hKs;
    public String hKt;
    public String hKu;
    public String hKv;
    public int hKw;
    public List<b> hKx;

    public d(boolean z, a aVar) {
        this.fCT = z;
        this.hKt = aVar.icon;
        this.hKs = aVar.title;
        this.hKu = aVar.booktown;
        this.hKv = aVar.tip;
        this.hKx = aVar.hKk;
        this.hKw = aVar.hKj;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hKr;
    }
}
