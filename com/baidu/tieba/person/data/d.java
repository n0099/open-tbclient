package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
import java.util.List;
/* loaded from: classes.dex */
public class d implements i {
    public static final BdUniqueId geL = BdUniqueId.gen();
    public boolean dWS;
    public String geM;
    public String geN;
    public String geO;
    public String geP;
    public int geQ;
    public List<b> geR;

    public d(boolean z, a aVar) {
        this.dWS = z;
        this.geN = aVar.icon;
        this.geM = aVar.title;
        this.geO = aVar.booktown;
        this.geP = aVar.tip;
        this.geR = aVar.geG;
        this.geQ = aVar.geF;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return geL;
    }
}
