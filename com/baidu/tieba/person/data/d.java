package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import java.util.List;
/* loaded from: classes5.dex */
public class d implements h {
    public static final BdUniqueId gtq = BdUniqueId.gen();
    public boolean epZ;
    public String gtr;
    public String gts;
    public String gtt;
    public String gtu;
    public int gtv;
    public List<b> gtw;

    public d(boolean z, a aVar) {
        this.epZ = z;
        this.gts = aVar.icon;
        this.gtr = aVar.title;
        this.gtt = aVar.booktown;
        this.gtu = aVar.tip;
        this.gtw = aVar.gtj;
        this.gtv = aVar.gti;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gtq;
    }
}
