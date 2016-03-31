package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.b;
import java.util.ArrayList;
import java.util.HashSet;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dr implements b.a {
    final /* synthetic */ dq djQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dr(dq dqVar) {
        this.djQ = dqVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.pb.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void y(String str, String str2, String str3) {
        com.baidu.tieba.pb.data.e eVar;
        com.baidu.tieba.tbadkCore.data.s sVar;
        com.baidu.tieba.pb.data.e eVar2;
        com.baidu.tieba.tbadkCore.data.s sVar2;
        com.baidu.tieba.tbadkCore.data.s sVar3;
        com.baidu.tieba.tbadkCore.data.s sVar4;
        boolean z;
        com.baidu.tieba.pb.data.e eVar3;
        com.baidu.tieba.pb.data.e eVar4;
        com.baidu.tieba.pb.data.e eVar5;
        eVar = this.djQ.ddq;
        if (eVar != null) {
            sVar = this.djQ.dcY;
            if (sVar != null) {
                eVar2 = this.djQ.ddq;
                if (eVar2.avu() != null) {
                    sVar2 = this.djQ.dcY;
                    if (sVar2.aTC() != null) {
                        sVar3 = this.djQ.dcY;
                        long templateId = sVar3.aTC().getTemplateId();
                        sVar4 = this.djQ.dcY;
                        String aSV = sVar4.aTC().aSV();
                        if ("VIEW_TRUE".equals(str3) || "VIEW_CAROUSEL".equals(str3)) {
                            if (this.djQ.djP.containsKey(Long.valueOf(templateId))) {
                                HashSet<String> hashSet = this.djQ.djP.get(Long.valueOf(templateId));
                                if (hashSet.add(str2)) {
                                    this.djQ.djP.put(Long.valueOf(templateId), hashSet);
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (!z) {
                                    eVar3 = this.djQ.ddq;
                                    String id = eVar3.avu().getId();
                                    eVar4 = this.djQ.ddq;
                                    String name = eVar4.avu().getName();
                                    eVar5 = this.djQ.ddq;
                                    com.baidu.tieba.pb.b.a(templateId, aSV, str, "PB", str2, str3, "tpoint", id, name, eVar5.getThreadId());
                                    return;
                                }
                                return;
                            }
                            HashSet<String> hashSet2 = new HashSet<>();
                            hashSet2.add(str2);
                            this.djQ.djP.put(Long.valueOf(templateId), hashSet2);
                        }
                        z = true;
                        if (!z) {
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.pb.b.a
    public int avb() {
        com.baidu.tieba.tbadkCore.data.s sVar;
        com.baidu.tieba.tbadkCore.data.s sVar2;
        sVar = this.djQ.dcY;
        if (et.g(sVar)) {
            sVar2 = this.djQ.dcY;
            ArrayList<com.baidu.tieba.tbadkCore.data.k> aSS = sVar2.aTC().aSS();
            if (aSS == null) {
                return 0;
            }
            return aSS.size();
        }
        return 0;
    }
}
