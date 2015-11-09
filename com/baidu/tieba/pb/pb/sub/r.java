package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.am;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements am.a {
    final /* synthetic */ NewSubPbActivity cnS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(NewSubPbActivity newSubPbActivity) {
        this.cnS = newSubPbActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0035, code lost:
        if (r0 != null) goto L22;
     */
    @Override // com.baidu.tieba.pb.pb.sub.am.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, int i, String str, com.baidu.tieba.pb.a.d dVar) {
        v vVar;
        v vVar2;
        am amVar;
        v vVar3;
        com.baidu.tbadk.editortools.c.p pVar;
        com.baidu.tbadk.editortools.c.p pVar2;
        v vVar4;
        am amVar2;
        am amVar3;
        v vVar5;
        vVar = this.cnS.cnJ;
        if (vVar != null) {
            vVar5 = this.cnS.cnJ;
            vVar5.ahP();
        }
        if (z) {
            vVar2 = this.cnS.cnJ;
            vVar2.hideNoDataView();
            if (dVar != null) {
                if (dVar.afs() == null) {
                    amVar3 = this.cnS.cnH;
                }
                com.baidu.tieba.tbadkCore.data.o afs = dVar.afs();
                amVar = this.cnS.cnH;
                afs.a(amVar.aiq());
                vVar3 = this.cnS.cnJ;
                if (vVar3 != null) {
                    vVar4 = this.cnS.cnJ;
                    amVar2 = this.cnS.cnH;
                    vVar4.a(dVar, amVar2.afl());
                }
                ao aoVar = new ao();
                aoVar.setData(dVar);
                pVar = this.cnS.cbv;
                if (pVar != null) {
                    pVar2 = this.cnS.cbv;
                    pVar2.a(dVar.afA());
                }
                aoVar.setType(0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, aoVar));
                return;
            }
            return;
        }
        this.cnS.showToast(str);
        this.cnS.L(i, str);
    }
}
