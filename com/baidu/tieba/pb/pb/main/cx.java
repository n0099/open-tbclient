package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.a;
import java.util.ArrayList;
import java.util.HashSet;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cx implements a.InterfaceC0074a {
    final /* synthetic */ cw cPA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(cw cwVar) {
        this.cPA = cwVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.pb.a.InterfaceC0074a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u(String str, String str2, String str3) {
        com.baidu.tieba.pb.a.c cVar;
        com.baidu.tieba.tbadkCore.data.r rVar;
        com.baidu.tieba.pb.a.c cVar2;
        com.baidu.tieba.tbadkCore.data.r rVar2;
        com.baidu.tieba.tbadkCore.data.r rVar3;
        com.baidu.tieba.tbadkCore.data.r rVar4;
        boolean z;
        com.baidu.tieba.pb.a.c cVar3;
        com.baidu.tieba.pb.a.c cVar4;
        com.baidu.tieba.pb.a.c cVar5;
        cVar = this.cPA.cJZ;
        if (cVar != null) {
            rVar = this.cPA.cJH;
            if (rVar != null) {
                cVar2 = this.cPA.cJZ;
                if (cVar2.aoE() != null) {
                    rVar2 = this.cPA.cJH;
                    if (rVar2.aMF() != null) {
                        rVar3 = this.cPA.cJH;
                        long templateId = rVar3.aMF().getTemplateId();
                        rVar4 = this.cPA.cJH;
                        String aMa = rVar4.aMF().aMa();
                        if ("VIEW_TRUE".equals(str3) || "VIEW_CAROUSEL".equals(str3)) {
                            if (this.cPA.cPz.containsKey(Long.valueOf(templateId))) {
                                HashSet<String> hashSet = this.cPA.cPz.get(Long.valueOf(templateId));
                                if (hashSet.add(str2)) {
                                    this.cPA.cPz.put(Long.valueOf(templateId), hashSet);
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (!z) {
                                    cVar3 = this.cPA.cJZ;
                                    String id = cVar3.aoE().getId();
                                    cVar4 = this.cPA.cJZ;
                                    String name = cVar4.aoE().getName();
                                    cVar5 = this.cPA.cJZ;
                                    com.baidu.tieba.pb.a.a(templateId, aMa, str, "PB", str2, str3, "tpoint", id, name, cVar5.getThreadId());
                                    return;
                                }
                                return;
                            }
                            HashSet<String> hashSet2 = new HashSet<>();
                            hashSet2.add(str2);
                            this.cPA.cPz.put(Long.valueOf(templateId), hashSet2);
                        }
                        z = true;
                        if (!z) {
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
        rVar = this.cPA.cJH;
        if (dy.g(rVar)) {
            rVar2 = this.cPA.cJH;
            ArrayList<com.baidu.tieba.tbadkCore.data.j> aLX = rVar2.aMF().aLX();
            if (aLX == null) {
                return 0;
            }
            return aLX.size();
        }
        return 0;
    }
}
