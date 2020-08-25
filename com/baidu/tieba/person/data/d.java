package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import java.util.List;
/* loaded from: classes16.dex */
public class d implements q {
    public static final BdUniqueId ldG = BdUniqueId.gen();
    public boolean ghr;
    public String ldH;
    public String ldI;
    public String ldJ;
    public String ldK;
    public int ldL;
    public List<b> ldM;

    public d(boolean z, a aVar) {
        this.ghr = z;
        this.ldI = aVar.icon;
        this.ldH = aVar.title;
        this.ldJ = aVar.booktown;
        this.ldK = aVar.tip;
        this.ldM = aVar.ldz;
        this.ldL = aVar.ldy;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ldG;
    }
}
