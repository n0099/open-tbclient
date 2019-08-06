package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.List;
/* loaded from: classes4.dex */
public class d implements m {
    public static final BdUniqueId ijP = BdUniqueId.gen();
    public boolean fZG;
    public String ijQ;
    public String ijR;
    public String ijS;
    public String ijT;
    public int ijU;
    public List<b> ijV;

    public d(boolean z, a aVar) {
        this.fZG = z;
        this.ijR = aVar.icon;
        this.ijQ = aVar.title;
        this.ijS = aVar.booktown;
        this.ijT = aVar.tip;
        this.ijV = aVar.ijI;
        this.ijU = aVar.ijH;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ijP;
    }
}
