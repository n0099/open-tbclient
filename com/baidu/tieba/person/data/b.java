package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
import java.util.List;
/* loaded from: classes.dex */
public class b implements f {
    public static final BdUniqueId fft = BdUniqueId.gen();
    public boolean cQT;
    public String ffu;
    public String ffv;
    public String ffw;
    public String ffx;
    public int ffy;
    public List<com.baidu.tieba.personInfo.b> ffz;

    public b(boolean z, com.baidu.tieba.personInfo.a aVar) {
        this.cQT = z;
        this.ffv = aVar.icon;
        this.ffu = aVar.title;
        this.ffw = aVar.booktown;
        this.ffx = aVar.tip;
        this.ffz = aVar.fji;
        this.ffy = aVar.fjh;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fft;
    }
}
