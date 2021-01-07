package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements n {
    public static final BdUniqueId mnX = BdUniqueId.gen();
    public boolean hli;
    public String mnY;
    public String mnZ;
    public String moa;
    public String mob;
    public int moc;
    public List<b> mod;

    public d(boolean z, a aVar) {
        this.hli = z;
        this.mnZ = aVar.icon;
        this.mnY = aVar.title;
        this.moa = aVar.booktown;
        this.mob = aVar.tip;
        this.mod = aVar.mnQ;
        this.moc = aVar.mnP;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return mnX;
    }
}
