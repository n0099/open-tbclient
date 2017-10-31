package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class d implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId fhx = BdUniqueId.gen();
    public boolean daz;
    public String fhA;
    public String fhB;
    public int fhC;
    public List<b> fhD;
    public String fhy;
    public String fhz;

    public d(boolean z, a aVar) {
        this.daz = z;
        this.fhz = aVar.icon;
        this.fhy = aVar.title;
        this.fhA = aVar.booktown;
        this.fhB = aVar.tip;
        this.fhD = aVar.fhs;
        this.fhC = aVar.fhr;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fhx;
    }
}
