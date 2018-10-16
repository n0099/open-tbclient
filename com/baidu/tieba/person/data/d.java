package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import java.util.List;
/* loaded from: classes5.dex */
public class d implements h {
    public static final BdUniqueId gim = BdUniqueId.gen();
    public boolean eeU;
    public String gin;
    public String gio;
    public String gip;
    public String giq;
    public int gir;
    public List<b> gis;

    public d(boolean z, a aVar) {
        this.eeU = z;
        this.gio = aVar.icon;
        this.gin = aVar.title;
        this.gip = aVar.booktown;
        this.giq = aVar.tip;
        this.gis = aVar.gif;
        this.gir = aVar.gie;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gim;
    }
}
