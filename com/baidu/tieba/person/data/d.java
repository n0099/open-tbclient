package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import java.util.List;
/* loaded from: classes16.dex */
public class d implements q {
    public static final BdUniqueId ldN = BdUniqueId.gen();
    public boolean ghv;
    public String ldO;
    public String ldP;
    public String ldQ;
    public String ldR;
    public int ldS;
    public List<b> ldT;

    public d(boolean z, a aVar) {
        this.ghv = z;
        this.ldP = aVar.icon;
        this.ldO = aVar.title;
        this.ldQ = aVar.booktown;
        this.ldR = aVar.tip;
        this.ldT = aVar.ldG;
        this.ldS = aVar.ldF;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ldN;
    }
}
