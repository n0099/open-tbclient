package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import java.util.List;
/* loaded from: classes5.dex */
public class d implements h {
    public static final BdUniqueId gjJ = BdUniqueId.gen();
    public boolean egp;
    public String gjK;
    public String gjL;
    public String gjM;
    public String gjN;
    public int gjO;
    public List<b> gjP;

    public d(boolean z, a aVar) {
        this.egp = z;
        this.gjL = aVar.icon;
        this.gjK = aVar.title;
        this.gjM = aVar.booktown;
        this.gjN = aVar.tip;
        this.gjP = aVar.gjC;
        this.gjO = aVar.gjB;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gjJ;
    }
}
