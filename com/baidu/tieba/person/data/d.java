package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements n {
    public static final BdUniqueId msK = BdUniqueId.gen();
    public boolean hlf;
    public String msL;
    public String msM;
    public String msN;
    public String msO;
    public int msP;
    public List<b> msQ;

    public d(boolean z, a aVar) {
        this.hlf = z;
        this.msM = aVar.icon;
        this.msL = aVar.title;
        this.msN = aVar.booktown;
        this.msO = aVar.tip;
        this.msQ = aVar.msD;
        this.msP = aVar.msC;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return msK;
    }
}
