package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
import java.util.List;
/* loaded from: classes.dex */
public class d implements i {
    public static final BdUniqueId gio = BdUniqueId.gen();
    public boolean ecK;
    public String gip;
    public String giq;
    public String gir;
    public String gis;
    public int git;
    public List<b> giu;

    public d(boolean z, a aVar) {
        this.ecK = z;
        this.giq = aVar.icon;
        this.gip = aVar.title;
        this.gir = aVar.booktown;
        this.gis = aVar.tip;
        this.giu = aVar.gij;
        this.git = aVar.gii;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gio;
    }
}
