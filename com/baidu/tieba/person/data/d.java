package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import java.util.List;
/* loaded from: classes5.dex */
public class d implements h {
    public static final BdUniqueId guv = BdUniqueId.gen();
    public boolean eqG;
    public int guA;
    public List<b> guB;
    public String guw;
    public String gux;
    public String guy;
    public String guz;

    public d(boolean z, a aVar) {
        this.eqG = z;
        this.gux = aVar.icon;
        this.guw = aVar.title;
        this.guy = aVar.booktown;
        this.guz = aVar.tip;
        this.guB = aVar.guo;
        this.guA = aVar.gun;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return guv;
    }
}
