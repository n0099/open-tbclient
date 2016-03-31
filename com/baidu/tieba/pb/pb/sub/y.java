package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.pb.main.et;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements b.a {
    final /* synthetic */ x dpf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.dpf = xVar;
    }

    @Override // com.baidu.tieba.pb.b.a
    public void y(String str, String str2, String str3) {
        com.baidu.tieba.pb.data.g gVar;
        com.baidu.tieba.tbadkCore.data.s sVar;
        com.baidu.tieba.pb.data.g gVar2;
        com.baidu.tieba.pb.data.g gVar3;
        com.baidu.tieba.tbadkCore.data.s sVar2;
        com.baidu.tieba.tbadkCore.data.s sVar3;
        com.baidu.tieba.tbadkCore.data.s sVar4;
        com.baidu.tieba.pb.data.g gVar4;
        com.baidu.tieba.pb.data.g gVar5;
        com.baidu.tieba.pb.data.g gVar6;
        gVar = this.dpf.dpd;
        if (gVar != null) {
            sVar = this.dpf.dcY;
            if (sVar != null) {
                gVar2 = this.dpf.dpd;
                if (gVar2.avP() != null) {
                    gVar3 = this.dpf.dpd;
                    if (gVar3.LC() != null) {
                        sVar2 = this.dpf.dcY;
                        if (sVar2.aTC() != null && !"VIEW_TRUE".equals(str3) && !"VIEW_CAROUSEL".equals(str3)) {
                            sVar3 = this.dpf.dcY;
                            long templateId = sVar3.aTC().getTemplateId();
                            sVar4 = this.dpf.dcY;
                            String aSV = sVar4.aTC().aSV();
                            gVar4 = this.dpf.dpd;
                            String id = gVar4.avP().getId();
                            gVar5 = this.dpf.dpd;
                            String name = gVar5.avP().getName();
                            gVar6 = this.dpf.dpd;
                            com.baidu.tieba.pb.b.a(templateId, aSV, str, "PB", str2, str3, "tpoint", id, name, gVar6.LC().getTid());
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
        sVar = this.dpf.dcY;
        if (et.g(sVar)) {
            sVar2 = this.dpf.dcY;
            ArrayList<com.baidu.tieba.tbadkCore.data.k> aSS = sVar2.aTC().aSS();
            if (aSS == null) {
                return 0;
            }
            return aSS.size();
        }
        return 0;
    }
}
