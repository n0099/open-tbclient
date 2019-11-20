package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.List;
/* loaded from: classes4.dex */
public class d implements m {
    public static final BdUniqueId ijH = BdUniqueId.gen();
    public boolean dQT;
    public String ijI;
    public String ijJ;
    public String ijK;
    public String ijL;
    public int ijM;
    public List<b> ijN;

    public d(boolean z, a aVar) {
        this.dQT = z;
        this.ijJ = aVar.icon;
        this.ijI = aVar.title;
        this.ijK = aVar.booktown;
        this.ijL = aVar.tip;
        this.ijN = aVar.ijA;
        this.ijM = aVar.ijz;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ijH;
    }
}
