package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.List;
/* loaded from: classes7.dex */
public class d implements m {
    public static final BdUniqueId jfb = BdUniqueId.gen();
    public boolean eHK;
    public String jfc;
    public String jfd;
    public String jfe;
    public String jff;
    public int jfg;
    public List<b> jfh;

    public d(boolean z, a aVar) {
        this.eHK = z;
        this.jfd = aVar.icon;
        this.jfc = aVar.title;
        this.jfe = aVar.booktown;
        this.jff = aVar.tip;
        this.jfh = aVar.jeU;
        this.jfg = aVar.jeT;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jfb;
    }
}
