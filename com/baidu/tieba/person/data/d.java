package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import java.util.List;
/* loaded from: classes5.dex */
public class d implements h {
    public static final BdUniqueId gqz = BdUniqueId.gen();
    public boolean eni;
    public String gqA;
    public String gqB;
    public String gqC;
    public String gqD;
    public int gqE;
    public List<b> gqF;

    public d(boolean z, a aVar) {
        this.eni = z;
        this.gqB = aVar.icon;
        this.gqA = aVar.title;
        this.gqC = aVar.booktown;
        this.gqD = aVar.tip;
        this.gqF = aVar.gqs;
        this.gqE = aVar.gqr;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gqz;
    }
}
