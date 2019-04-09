package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.List;
/* loaded from: classes4.dex */
public class d implements m {
    public static final BdUniqueId hKs = BdUniqueId.gen();
    public boolean fCT;
    public String hKt;
    public String hKu;
    public String hKv;
    public String hKw;
    public int hKx;
    public List<b> hKy;

    public d(boolean z, a aVar) {
        this.fCT = z;
        this.hKu = aVar.icon;
        this.hKt = aVar.title;
        this.hKv = aVar.booktown;
        this.hKw = aVar.tip;
        this.hKy = aVar.hKl;
        this.hKx = aVar.hKk;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hKs;
    }
}
