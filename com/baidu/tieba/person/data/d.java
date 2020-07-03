package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import java.util.List;
/* loaded from: classes9.dex */
public class d implements q {
    public static final BdUniqueId kEM = BdUniqueId.gen();
    public boolean fPZ;
    public String kEN;
    public String kEO;
    public String kEP;
    public String kEQ;
    public int kER;
    public List<b> kES;

    public d(boolean z, a aVar) {
        this.fPZ = z;
        this.kEO = aVar.icon;
        this.kEN = aVar.title;
        this.kEP = aVar.booktown;
        this.kEQ = aVar.tip;
        this.kES = aVar.kEF;
        this.kER = aVar.kEE;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kEM;
    }
}
