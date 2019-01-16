package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import java.util.List;
/* loaded from: classes5.dex */
public class d implements h {
    public static final BdUniqueId guu = BdUniqueId.gen();
    public boolean eqF;
    public List<b> guA;
    public String guv;
    public String guw;
    public String gux;
    public String guy;
    public int guz;

    public d(boolean z, a aVar) {
        this.eqF = z;
        this.guw = aVar.icon;
        this.guv = aVar.title;
        this.gux = aVar.booktown;
        this.guy = aVar.tip;
        this.guA = aVar.gun;
        this.guz = aVar.gum;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return guu;
    }
}
