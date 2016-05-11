package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.b;
import java.util.ArrayList;
import java.util.HashSet;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class di implements b.a {
    final /* synthetic */ dh dmm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public di(dh dhVar) {
        this.dmm = dhVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.pb.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void z(String str, String str2, String str3) {
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
        eVar = this.dmm.dfK;
        if (eVar != null) {
            sVar = this.dmm.dfs;
            if (sVar != null) {
                eVar2 = this.dmm.dfK;
                if (eVar2.avA() != null) {
                    sVar2 = this.dmm.dfs;
                    if (sVar2.aUc() != null) {
                        sVar3 = this.dmm.dfs;
                        long templateId = sVar3.aUc().getTemplateId();
                        sVar4 = this.dmm.dfs;
                        String aTw = sVar4.aUc().aTw();
                        if ("VIEW_TRUE".equals(str3) || "VIEW_CAROUSEL".equals(str3)) {
                            if (this.dmm.dml.containsKey(Long.valueOf(templateId))) {
                                HashSet<String> hashSet = this.dmm.dml.get(Long.valueOf(templateId));
                                if (hashSet.add(str2)) {
                                    this.dmm.dml.put(Long.valueOf(templateId), hashSet);
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (!z) {
                                    eVar3 = this.dmm.dfK;
                                    String id = eVar3.avA().getId();
                                    eVar4 = this.dmm.dfK;
                                    String name = eVar4.avA().getName();
                                    eVar5 = this.dmm.dfK;
                                    com.baidu.tieba.pb.b.a(templateId, aTw, str, "PB", str2, str3, "tpoint", id, name, eVar5.getThreadId());
                                    return;
                                }
                                return;
                            }
                            HashSet<String> hashSet2 = new HashSet<>();
                            hashSet2.add(str2);
                            this.dmm.dml.put(Long.valueOf(templateId), hashSet2);
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
    public int avh() {
        com.baidu.tieba.tbadkCore.data.s sVar;
        com.baidu.tieba.tbadkCore.data.s sVar2;
        sVar = this.dmm.dfs;
        if (ek.g(sVar)) {
            sVar2 = this.dmm.dfs;
            ArrayList<com.baidu.tieba.tbadkCore.data.k> aTt = sVar2.aUc().aTt();
            if (aTt == null) {
                return 0;
            }
            return aTt.size();
        }
        return 0;
    }
}
