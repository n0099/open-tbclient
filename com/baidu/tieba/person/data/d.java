package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements h {
    public static final BdUniqueId gaK = BdUniqueId.gen();
    public boolean dXb;
    public String gaL;
    public String gaM;
    public String gaN;
    public String gaO;
    public int gaP;
    public List<b> gaQ;

    public d(boolean z, a aVar) {
        this.dXb = z;
        this.gaM = aVar.icon;
        this.gaL = aVar.title;
        this.gaN = aVar.booktown;
        this.gaO = aVar.tip;
        this.gaQ = aVar.gaD;
        this.gaP = aVar.gaC;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gaK;
    }
}
