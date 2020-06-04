package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
import java.util.List;
/* loaded from: classes9.dex */
public class d implements o {
    public static final BdUniqueId kla = BdUniqueId.gen();
    public boolean fEQ;
    public String klb;
    public String klc;
    public String kld;
    public String kle;
    public int klf;
    public List<b> klg;

    public d(boolean z, a aVar) {
        this.fEQ = z;
        this.klc = aVar.icon;
        this.klb = aVar.title;
        this.kld = aVar.booktown;
        this.kle = aVar.tip;
        this.klg = aVar.kkT;
        this.klf = aVar.kkS;
    }

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return kla;
    }
}
