package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
import java.util.List;
/* loaded from: classes.dex */
public class d implements i {
    public static final BdUniqueId git = BdUniqueId.gen();
    public boolean ecO;
    public String giu;
    public String giv;
    public String giw;
    public String gix;
    public int giy;
    public List<b> giz;

    public d(boolean z, a aVar) {
        this.ecO = z;
        this.giv = aVar.icon;
        this.giu = aVar.title;
        this.giw = aVar.booktown;
        this.gix = aVar.tip;
        this.giz = aVar.gio;
        this.giy = aVar.gin;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return git;
    }
}
