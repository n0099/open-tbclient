package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.ak;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements ak.a {
    final /* synthetic */ NewSubPbActivity cmr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(NewSubPbActivity newSubPbActivity) {
        this.cmr = newSubPbActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0035, code lost:
        if (r0 != null) goto L22;
     */
    @Override // com.baidu.tieba.pb.pb.sub.ak.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, int i, String str, com.baidu.tieba.pb.a.c cVar) {
        t tVar;
        t tVar2;
        ak akVar;
        t tVar3;
        com.baidu.tbadk.editortools.c.n nVar;
        com.baidu.tbadk.editortools.c.n nVar2;
        t tVar4;
        ak akVar2;
        ak akVar3;
        t tVar5;
        tVar = this.cmr.cmk;
        if (tVar != null) {
            tVar5 = this.cmr.cmk;
            tVar5.ahn();
        }
        if (z) {
            tVar2 = this.cmr.cmk;
            tVar2.hideNoDataView();
            if (cVar != null) {
                if (cVar.aeZ() == null) {
                    akVar3 = this.cmr.cmi;
                }
                com.baidu.tieba.tbadkCore.data.k aeZ = cVar.aeZ();
                akVar = this.cmr.cmi;
                aeZ.a(akVar.ahO());
                tVar3 = this.cmr.cmk;
                if (tVar3 != null) {
                    tVar4 = this.cmr.cmk;
                    akVar2 = this.cmr.cmi;
                    tVar4.a(cVar, akVar2.aeS());
                }
                am amVar = new am();
                amVar.setData(cVar);
                nVar = this.cmr.caJ;
                if (nVar != null) {
                    nVar2 = this.cmr.caJ;
                    nVar2.a(cVar.afh());
                }
                amVar.setType(0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, amVar));
                return;
            }
            return;
        }
        this.cmr.showToast(str);
        this.cmr.K(i, str);
    }
}
