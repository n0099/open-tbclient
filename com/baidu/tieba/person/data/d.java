package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements h {
    public static final BdUniqueId fTC = BdUniqueId.gen();
    public boolean dPN;
    public String fTD;
    public String fTE;
    public String fTF;
    public String fTG;
    public int fTH;
    public List<b> fTI;

    public d(boolean z, a aVar) {
        this.dPN = z;
        this.fTE = aVar.icon;
        this.fTD = aVar.title;
        this.fTF = aVar.booktown;
        this.fTG = aVar.tip;
        this.fTI = aVar.fTv;
        this.fTH = aVar.fTu;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fTC;
    }
}
