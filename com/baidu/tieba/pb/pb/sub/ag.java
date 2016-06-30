package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.pb.main.er;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements b.a {
    final /* synthetic */ af dXy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar) {
        this.dXy = afVar;
    }

    @Override // com.baidu.tieba.pb.b.a
    public void c(String str, String str2, String str3, String str4, String str5) {
        com.baidu.tieba.pb.data.m mVar;
        com.baidu.tieba.tbadkCore.data.s sVar;
        com.baidu.tieba.pb.data.m mVar2;
        com.baidu.tieba.pb.data.m mVar3;
        com.baidu.tieba.tbadkCore.data.s sVar2;
        com.baidu.tieba.tbadkCore.data.s sVar3;
        com.baidu.tieba.tbadkCore.data.s sVar4;
        com.baidu.tieba.pb.data.m mVar4;
        com.baidu.tieba.pb.data.m mVar5;
        com.baidu.tieba.pb.data.m mVar6;
        mVar = this.dXy.dXu;
        if (mVar != null) {
            sVar = this.dXy.dMl;
            if (sVar != null) {
                mVar2 = this.dXy.dXu;
                if (mVar2.aEl() != null) {
                    mVar3 = this.dXy.dXu;
                    if (mVar3.Ix() != null) {
                        sVar2 = this.dXy.dMl;
                        if (sVar2.bcw() != null && !"VIEW_TRUE".equals(str3) && !"VIEW_CAROUSEL".equals(str3)) {
                            sVar3 = this.dXy.dMl;
                            long templateId = sVar3.bcw().getTemplateId();
                            sVar4 = this.dXy.dMl;
                            String bbP = sVar4.bcw().bbP();
                            mVar4 = this.dXy.dXu;
                            String id = mVar4.aEl().getId();
                            mVar5 = this.dXy.dXu;
                            String name = mVar5.aEl().getName();
                            mVar6 = this.dXy.dXu;
                            com.baidu.tieba.pb.b.a(templateId, bbP, str, "PB", str2, str3, "tpoint", str4, str5, id, name, mVar6.Ix().getTid());
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.pb.b.a
    public int aDp() {
        com.baidu.tieba.tbadkCore.data.s sVar;
        com.baidu.tieba.tbadkCore.data.s sVar2;
        sVar = this.dXy.dMl;
        if (er.f(sVar)) {
            sVar2 = this.dXy.dMl;
            ArrayList<com.baidu.tieba.tbadkCore.data.k> bbM = sVar2.bcw().bbM();
            if (bbM == null) {
                return 0;
            }
            return bbM.size();
        }
        return 0;
    }
}
