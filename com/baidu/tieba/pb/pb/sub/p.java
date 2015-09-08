package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.ak;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements ak.a {
    final /* synthetic */ NewSubPbActivity cgV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(NewSubPbActivity newSubPbActivity) {
        this.cgV = newSubPbActivity;
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
        tVar = this.cgV.cgO;
        if (tVar != null) {
            tVar5 = this.cgV.cgO;
            tVar5.afq();
        }
        if (z) {
            tVar2 = this.cgV.cgO;
            tVar2.hideNoDataView();
            if (cVar != null) {
                if (cVar.adb() == null) {
                    akVar3 = this.cgV.cgM;
                }
                com.baidu.tieba.tbadkCore.data.i adb = cVar.adb();
                akVar = this.cgV.cgM;
                adb.a(akVar.afQ());
                tVar3 = this.cgV.cgO;
                if (tVar3 != null) {
                    tVar4 = this.cgV.cgO;
                    akVar2 = this.cgV.cgM;
                    tVar4.a(cVar, akVar2.acU());
                }
                am amVar = new am();
                amVar.setData(cVar);
                nVar = this.cgV.bWV;
                if (nVar != null) {
                    nVar2 = this.cgV.bWV;
                    nVar2.a(cVar.adj());
                }
                amVar.setType(0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, amVar));
                return;
            }
            return;
        }
        this.cgV.showToast(str);
        this.cgV.afh();
    }
}
