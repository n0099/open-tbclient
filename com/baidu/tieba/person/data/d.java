package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.List;
/* loaded from: classes9.dex */
public class d implements m {
    public static final BdUniqueId jgc = BdUniqueId.gen();
    public boolean eLE;
    public String jgd;
    public String jge;
    public String jgf;
    public String jgg;
    public int jgh;
    public List<b> jgi;

    public d(boolean z, a aVar) {
        this.eLE = z;
        this.jge = aVar.icon;
        this.jgd = aVar.title;
        this.jgf = aVar.booktown;
        this.jgg = aVar.tip;
        this.jgi = aVar.jfV;
        this.jgh = aVar.jfU;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jgc;
    }
}
