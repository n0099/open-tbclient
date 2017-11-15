package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class d implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId fhT = BdUniqueId.gen();
    public boolean daT;
    public String fhU;
    public String fhV;
    public String fhW;
    public String fhX;
    public int fhY;
    public List<b> fhZ;

    public d(boolean z, a aVar) {
        this.daT = z;
        this.fhV = aVar.icon;
        this.fhU = aVar.title;
        this.fhW = aVar.booktown;
        this.fhX = aVar.tip;
        this.fhZ = aVar.fhO;
        this.fhY = aVar.fhN;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fhT;
    }
}
