package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import java.util.List;
/* loaded from: classes22.dex */
public class d implements q {
    public static final BdUniqueId lUp = BdUniqueId.gen();
    public boolean gQx;
    public String lUq;
    public String lUr;
    public String lUs;
    public String lUt;
    public int lUu;
    public List<b> lUv;

    public d(boolean z, a aVar) {
        this.gQx = z;
        this.lUr = aVar.icon;
        this.lUq = aVar.title;
        this.lUs = aVar.booktown;
        this.lUt = aVar.tip;
        this.lUv = aVar.lUi;
        this.lUu = aVar.lUh;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lUp;
    }
}
