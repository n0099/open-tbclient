package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.an;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements an.a {
    final /* synthetic */ NewSubPbActivity cHd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(NewSubPbActivity newSubPbActivity) {
        this.cHd = newSubPbActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0035, code lost:
        if (r0 != null) goto L22;
     */
    @Override // com.baidu.tieba.pb.pb.sub.an.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, int i, String str, com.baidu.tieba.pb.a.d dVar) {
        w wVar;
        w wVar2;
        an anVar;
        w wVar3;
        com.baidu.tbadk.editortools.d.p pVar;
        com.baidu.tbadk.editortools.d.p pVar2;
        w wVar4;
        an anVar2;
        an anVar3;
        w wVar5;
        wVar = this.cHd.cGU;
        if (wVar != null) {
            wVar5 = this.cHd.cGU;
            wVar5.ams();
        }
        if (z) {
            wVar2 = this.cHd.cGU;
            wVar2.hideNoDataView();
            if (dVar != null) {
                if (dVar.ajK() == null) {
                    anVar3 = this.cHd.cGS;
                }
                com.baidu.tieba.tbadkCore.data.o ajK = dVar.ajK();
                anVar = this.cHd.cGS;
                ajK.a(anVar.amT());
                wVar3 = this.cHd.cGU;
                if (wVar3 != null) {
                    wVar4 = this.cHd.cGU;
                    anVar2 = this.cHd.cGS;
                    wVar4.a(dVar, anVar2.ajD());
                }
                ap apVar = new ap();
                apVar.setData(dVar);
                pVar = this.cHd.ceY;
                if (pVar != null) {
                    pVar2 = this.cHd.ceY;
                    pVar2.a(dVar.ajS());
                }
                apVar.setType(0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, apVar));
                return;
            }
            return;
        }
        this.cHd.showToast(str);
        this.cHd.M(i, str);
    }
}
