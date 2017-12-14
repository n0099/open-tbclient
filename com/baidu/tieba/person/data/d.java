package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
import java.util.List;
/* loaded from: classes.dex */
public class d implements f {
    public static final BdUniqueId frP = BdUniqueId.gen();
    public boolean dkF;
    public String frQ;
    public String frR;
    public String frS;
    public String frT;
    public int frU;
    public List<b> frV;

    public d(boolean z, a aVar) {
        this.dkF = z;
        this.frR = aVar.icon;
        this.frQ = aVar.title;
        this.frS = aVar.booktown;
        this.frT = aVar.tip;
        this.frV = aVar.frK;
        this.frU = aVar.frJ;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return frP;
    }
}
