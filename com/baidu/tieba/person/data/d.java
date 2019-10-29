package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.List;
/* loaded from: classes4.dex */
public class d implements m {
    public static final BdUniqueId iky = BdUniqueId.gen();
    public boolean dRK;
    public String ikA;
    public String ikB;
    public String ikC;
    public int ikD;
    public List<b> ikE;
    public String ikz;

    public d(boolean z, a aVar) {
        this.dRK = z;
        this.ikA = aVar.icon;
        this.ikz = aVar.title;
        this.ikB = aVar.booktown;
        this.ikC = aVar.tip;
        this.ikE = aVar.ikr;
        this.ikD = aVar.ikq;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iky;
    }
}
