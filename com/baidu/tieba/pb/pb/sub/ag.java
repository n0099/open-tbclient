package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.pb.main.ev;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements b.a {
    final /* synthetic */ af eka;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar) {
        this.eka = afVar;
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
        mVar = this.eka.ejW;
        if (mVar != null) {
            sVar = this.eka.dYv;
            if (sVar != null) {
                mVar2 = this.eka.ejW;
                if (mVar2.aHv() != null) {
                    mVar3 = this.eka.ejW;
                    if (mVar3.Iw() != null) {
                        sVar2 = this.eka.dYv;
                        if (sVar2.bfL() != null && !"VIEW_TRUE".equals(str3) && !"VIEW_CAROUSEL".equals(str3)) {
                            sVar3 = this.eka.dYv;
                            long templateId = sVar3.bfL().getTemplateId();
                            sVar4 = this.eka.dYv;
                            String bfe = sVar4.bfL().bfe();
                            mVar4 = this.eka.ejW;
                            String id = mVar4.aHv().getId();
                            mVar5 = this.eka.ejW;
                            String name = mVar5.aHv().getName();
                            mVar6 = this.eka.ejW;
                            com.baidu.tieba.pb.b.a(templateId, bfe, str, "PB", str2, str3, "tpoint", str4, str5, id, name, mVar6.Iw().getTid());
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.pb.b.a
    public int aGz() {
        com.baidu.tieba.tbadkCore.data.s sVar;
        com.baidu.tieba.tbadkCore.data.s sVar2;
        sVar = this.eka.dYv;
        if (ev.g(sVar)) {
            sVar2 = this.eka.dYv;
            ArrayList<com.baidu.tieba.tbadkCore.data.k> bfb = sVar2.bfL().bfb();
            if (bfb == null) {
                return 0;
            }
            return bfb.size();
        }
        return 0;
    }
}
