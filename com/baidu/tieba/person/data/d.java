package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class d implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId fqR = BdUniqueId.gen();
    public boolean djA;
    public String fqS;
    public String fqT;
    public String fqU;
    public String fqV;
    public int fqW;
    public List<b> fqX;

    public d(boolean z, a aVar) {
        this.djA = z;
        this.fqT = aVar.icon;
        this.fqS = aVar.title;
        this.fqU = aVar.booktown;
        this.fqV = aVar.tip;
        this.fqX = aVar.fqM;
        this.fqW = aVar.fqL;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fqR;
    }
}
