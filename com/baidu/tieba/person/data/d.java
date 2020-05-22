package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
import java.util.List;
/* loaded from: classes9.dex */
public class d implements o {
    public static final BdUniqueId kjU = BdUniqueId.gen();
    public boolean fEF;
    public String kjV;
    public String kjW;
    public String kjX;
    public String kjY;
    public int kjZ;
    public List<b> kka;

    public d(boolean z, a aVar) {
        this.fEF = z;
        this.kjW = aVar.icon;
        this.kjV = aVar.title;
        this.kjX = aVar.booktown;
        this.kjY = aVar.tip;
        this.kka = aVar.kjN;
        this.kjZ = aVar.kjM;
    }

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return kjU;
    }
}
