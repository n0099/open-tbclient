package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.List;
/* loaded from: classes9.dex */
public class d implements m {
    public static final BdUniqueId jge = BdUniqueId.gen();
    public boolean eLF;
    public String jgf;
    public String jgg;
    public String jgh;
    public String jgi;
    public int jgj;
    public List<b> jgk;

    public d(boolean z, a aVar) {
        this.eLF = z;
        this.jgg = aVar.icon;
        this.jgf = aVar.title;
        this.jgh = aVar.booktown;
        this.jgi = aVar.tip;
        this.jgk = aVar.jfX;
        this.jgj = aVar.jfW;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jge;
    }
}
