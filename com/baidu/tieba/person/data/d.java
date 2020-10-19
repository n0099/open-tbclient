package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import java.util.List;
/* loaded from: classes22.dex */
public class d implements q {
    public static final BdUniqueId lBW = BdUniqueId.gen();
    public boolean gyX;
    public String lBX;
    public String lBY;
    public String lBZ;
    public String lCa;
    public int lCb;
    public List<b> lCc;

    public d(boolean z, a aVar) {
        this.gyX = z;
        this.lBY = aVar.icon;
        this.lBX = aVar.title;
        this.lBZ = aVar.booktown;
        this.lCa = aVar.tip;
        this.lCc = aVar.lBP;
        this.lCb = aVar.lBO;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lBW;
    }
}
