package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.pb.a;
import com.baidu.tieba.pb.pb.main.dy;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements a.InterfaceC0074a {
    final /* synthetic */ w cUl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.cUl = wVar;
    }

    @Override // com.baidu.tieba.pb.a.InterfaceC0074a
    public void u(String str, String str2, String str3) {
        com.baidu.tieba.pb.a.d dVar;
        com.baidu.tieba.tbadkCore.data.r rVar;
        com.baidu.tieba.pb.a.d dVar2;
        com.baidu.tieba.pb.a.d dVar3;
        com.baidu.tieba.tbadkCore.data.r rVar2;
        com.baidu.tieba.tbadkCore.data.r rVar3;
        com.baidu.tieba.tbadkCore.data.r rVar4;
        com.baidu.tieba.pb.a.d dVar4;
        com.baidu.tieba.pb.a.d dVar5;
        com.baidu.tieba.pb.a.d dVar6;
        dVar = this.cUl.cUj;
        if (dVar != null) {
            rVar = this.cUl.cJH;
            if (rVar != null) {
                dVar2 = this.cUl.cUj;
                if (dVar2.aoX() != null) {
                    dVar3 = this.cUl.cUj;
                    if (dVar3.Ki() != null) {
                        rVar2 = this.cUl.cJH;
                        if (rVar2.aMF() != null && !"VIEW_TRUE".equals(str3) && !"VIEW_CAROUSEL".equals(str3)) {
                            rVar3 = this.cUl.cJH;
                            long templateId = rVar3.aMF().getTemplateId();
                            rVar4 = this.cUl.cJH;
                            String aMa = rVar4.aMF().aMa();
                            dVar4 = this.cUl.cUj;
                            String id = dVar4.aoX().getId();
                            dVar5 = this.cUl.cUj;
                            String name = dVar5.aoX().getName();
                            dVar6 = this.cUl.cUj;
                            com.baidu.tieba.pb.a.a(templateId, aMa, str, "PB", str2, str3, "tpoint", id, name, dVar6.Ki().getTid());
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.pb.a.InterfaceC0074a
    public int aoo() {
        com.baidu.tieba.tbadkCore.data.r rVar;
        com.baidu.tieba.tbadkCore.data.r rVar2;
        rVar = this.cUl.cJH;
        if (dy.g(rVar)) {
            rVar2 = this.cUl.cJH;
            ArrayList<com.baidu.tieba.tbadkCore.data.j> aLX = rVar2.aMF().aLX();
            if (aLX == null) {
                return 0;
            }
            return aLX.size();
        }
        return 0;
    }
}
