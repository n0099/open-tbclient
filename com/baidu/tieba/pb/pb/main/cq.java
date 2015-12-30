package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.a;
import java.util.ArrayList;
import java.util.HashSet;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cq implements a.InterfaceC0072a {
    final /* synthetic */ cp cHR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(cp cpVar) {
        this.cHR = cpVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.pb.a.InterfaceC0072a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void t(String str, String str2, String str3) {
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
        cVar = this.cHR.cDR;
        if (cVar != null) {
            rVar = this.cHR.cDb;
            if (rVar != null) {
                cVar2 = this.cHR.cDR;
                if (cVar2.akG() != null) {
                    rVar2 = this.cHR.cDb;
                    if (rVar2.aFA() != null) {
                        rVar3 = this.cHR.cDb;
                        long templateId = rVar3.aFA().getTemplateId();
                        rVar4 = this.cHR.cDb;
                        String aEU = rVar4.aFA().aEU();
                        if ("VIEW_TRUE".equals(str3) || "VIEW_CAROUSEL".equals(str3)) {
                            if (this.cHR.cHQ.containsKey(Long.valueOf(templateId))) {
                                HashSet<String> hashSet = this.cHR.cHQ.get(Long.valueOf(templateId));
                                if (hashSet.add(str2)) {
                                    this.cHR.cHQ.put(Long.valueOf(templateId), hashSet);
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (!z) {
                                    cVar3 = this.cHR.cDR;
                                    String id = cVar3.akG().getId();
                                    cVar4 = this.cHR.cDR;
                                    String name = cVar4.akG().getName();
                                    cVar5 = this.cHR.cDR;
                                    com.baidu.tieba.pb.a.a(templateId, aEU, str, "PB", str2, str3, "tpoint", id, name, cVar5.getThreadId());
                                    return;
                                }
                                return;
                            }
                            HashSet<String> hashSet2 = new HashSet<>();
                            hashSet2.add(str2);
                            this.cHR.cHQ.put(Long.valueOf(templateId), hashSet2);
                        }
                        z = true;
                        if (!z) {
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.pb.a.InterfaceC0072a
    public int akq() {
        com.baidu.tieba.tbadkCore.data.r rVar;
        com.baidu.tieba.tbadkCore.data.r rVar2;
        rVar = this.cHR.cDb;
        if (dj.e(rVar)) {
            rVar2 = this.cHR.cDb;
            ArrayList<com.baidu.tieba.tbadkCore.data.j> aER = rVar2.aFA().aER();
            if (aER == null) {
                return 0;
            }
            return aER.size();
        }
        return 0;
    }
}
