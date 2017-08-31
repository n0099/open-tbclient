package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
import java.util.List;
/* loaded from: classes.dex */
public class b implements f {
    public static final BdUniqueId feA = BdUniqueId.gen();
    public boolean cPZ;
    public String feB;
    public String feC;
    public String feD;
    public String feE;
    public int feF;
    public List<com.baidu.tieba.personInfo.b> feG;

    public b(boolean z, com.baidu.tieba.personInfo.a aVar) {
        this.cPZ = z;
        this.feC = aVar.icon;
        this.feB = aVar.title;
        this.feD = aVar.booktown;
        this.feE = aVar.tip;
        this.feG = aVar.fio;
        this.feF = aVar.fin;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return feA;
    }
}
