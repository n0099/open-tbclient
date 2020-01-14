package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.List;
/* loaded from: classes7.dex */
public class d implements m {
    public static final BdUniqueId jfg = BdUniqueId.gen();
    public boolean eHK;
    public String jfh;
    public String jfi;
    public String jfj;
    public String jfk;
    public int jfl;
    public List<b> jfm;

    public d(boolean z, a aVar) {
        this.eHK = z;
        this.jfi = aVar.icon;
        this.jfh = aVar.title;
        this.jfj = aVar.booktown;
        this.jfk = aVar.tip;
        this.jfm = aVar.jeZ;
        this.jfl = aVar.jeY;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jfg;
    }
}
