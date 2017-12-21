package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
import java.util.List;
/* loaded from: classes.dex */
public class d implements f {
    public static final BdUniqueId frU = BdUniqueId.gen();
    public boolean dkJ;
    public String frV;
    public String frW;
    public String frX;
    public String frY;
    public int frZ;
    public List<b> fsa;

    public d(boolean z, a aVar) {
        this.dkJ = z;
        this.frW = aVar.icon;
        this.frV = aVar.title;
        this.frX = aVar.booktown;
        this.frY = aVar.tip;
        this.fsa = aVar.frP;
        this.frZ = aVar.frO;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return frU;
    }
}
