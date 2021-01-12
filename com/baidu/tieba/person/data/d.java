package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements n {
    public static final BdUniqueId mjt = BdUniqueId.gen();
    public boolean hgB;
    public String mju;
    public String mjv;
    public String mjw;
    public String mjx;
    public int mjy;
    public List<b> mjz;

    public d(boolean z, a aVar) {
        this.hgB = z;
        this.mjv = aVar.icon;
        this.mju = aVar.title;
        this.mjw = aVar.booktown;
        this.mjx = aVar.tip;
        this.mjz = aVar.mjm;
        this.mjy = aVar.mjl;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return mjt;
    }
}
