package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import java.util.List;
/* loaded from: classes21.dex */
public class d implements q {
    public static final BdUniqueId lUH = BdUniqueId.gen();
    public boolean gQe;
    public String lUI;
    public String lUJ;
    public String lUK;
    public String lUL;
    public int lUM;
    public List<b> lUN;

    public d(boolean z, a aVar) {
        this.gQe = z;
        this.lUJ = aVar.icon;
        this.lUI = aVar.title;
        this.lUK = aVar.booktown;
        this.lUL = aVar.tip;
        this.lUN = aVar.lUA;
        this.lUM = aVar.lUz;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lUH;
    }
}
