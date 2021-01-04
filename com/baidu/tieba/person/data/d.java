package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements n {
    public static final BdUniqueId mnY = BdUniqueId.gen();
    public boolean hli;
    public String mnZ;
    public String moa;
    public String mob;
    public String moc;
    public int mod;
    public List<b> moe;

    public d(boolean z, a aVar) {
        this.hli = z;
        this.moa = aVar.icon;
        this.mnZ = aVar.title;
        this.mob = aVar.booktown;
        this.moc = aVar.tip;
        this.moe = aVar.mnR;
        this.mod = aVar.mnQ;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return mnY;
    }
}
