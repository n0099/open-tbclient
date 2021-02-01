package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements n {
    public static final BdUniqueId msv = BdUniqueId.gen();
    public boolean hkR;
    public int msA;
    public List<b> msB;
    public String msw;
    public String msx;
    public String msy;
    public String msz;

    public d(boolean z, a aVar) {
        this.hkR = z;
        this.msx = aVar.icon;
        this.msw = aVar.title;
        this.msy = aVar.booktown;
        this.msz = aVar.tip;
        this.msB = aVar.mso;
        this.msA = aVar.msn;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return msv;
    }
}
