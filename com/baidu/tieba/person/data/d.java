package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import java.util.List;
/* loaded from: classes5.dex */
public class d implements h {
    public static final BdUniqueId gin = BdUniqueId.gen();
    public boolean eeV;
    public String gio;
    public String gip;
    public String giq;
    public String gir;
    public int gis;
    public List<b> git;

    public d(boolean z, a aVar) {
        this.eeV = z;
        this.gip = aVar.icon;
        this.gio = aVar.title;
        this.giq = aVar.booktown;
        this.gir = aVar.tip;
        this.git = aVar.gig;
        this.gis = aVar.gif;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gin;
    }
}
