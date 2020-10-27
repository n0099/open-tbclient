package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import java.util.List;
/* loaded from: classes22.dex */
public class d implements q {
    public static final BdUniqueId lOt = BdUniqueId.gen();
    public boolean gKL;
    public String lOu;
    public String lOv;
    public String lOw;
    public String lOx;
    public int lOy;
    public List<b> lOz;

    public d(boolean z, a aVar) {
        this.gKL = z;
        this.lOv = aVar.icon;
        this.lOu = aVar.title;
        this.lOw = aVar.booktown;
        this.lOx = aVar.tip;
        this.lOz = aVar.lOm;
        this.lOy = aVar.lOl;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lOt;
    }
}
