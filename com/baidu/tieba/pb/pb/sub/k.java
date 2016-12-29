package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.bc;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements bc.a {
    final /* synthetic */ NewSubPbActivity eis;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(NewSubPbActivity newSubPbActivity) {
        this.eis = newSubPbActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0050, code lost:
        if (r0 != null) goto L33;
     */
    @Override // com.baidu.tieba.pb.pb.sub.bc.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, int i, String str, com.baidu.tieba.pb.data.j jVar) {
        ao aoVar;
        b bVar;
        ao aoVar2;
        bc bcVar;
        ao aoVar3;
        com.baidu.tbadk.editortools.e.p pVar;
        com.baidu.tbadk.editortools.e.p pVar2;
        ao aoVar4;
        bc bcVar2;
        bc bcVar3;
        boolean z2;
        bc bcVar4;
        b bVar2;
        b bVar3;
        ao aoVar5;
        aoVar = this.eis.eid;
        if (aoVar != null) {
            aoVar5 = this.eis.eid;
            aoVar5.aNf();
        }
        bVar = this.eis.eip;
        if (bVar != null) {
            bVar2 = this.eis.eip;
            if (bVar2.aMO()) {
                bVar3 = this.eis.eip;
                bVar3.nR(r.d.cp_bg_line_k_alpha40);
            }
        }
        if (z) {
            aoVar2 = this.eis.eid;
            aoVar2.hideNoDataView();
            if (jVar != null) {
                if (jVar.aIF() == null) {
                    bcVar4 = this.eis.eib;
                }
                com.baidu.tieba.tbadkCore.data.q aIF = jVar.aIF();
                bcVar = this.eis.eib;
                aIF.a(bcVar.aNF());
                aoVar3 = this.eis.eid;
                if (aoVar3 != null) {
                    aoVar4 = this.eis.eid;
                    bcVar2 = this.eis.eib;
                    int aIu = bcVar2.aIu();
                    bcVar3 = this.eis.eib;
                    aoVar4.a(jVar, aIu, bcVar3.aNH() != null);
                    z2 = this.eis.eim;
                    if (z2) {
                        this.eis.aMT();
                        this.eis.eim = false;
                    }
                }
                com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                dVar.setData(jVar);
                pVar = this.eis.ddg;
                if (pVar != null) {
                    pVar2 = this.eis.ddg;
                    pVar2.a(jVar.avW());
                }
                dVar.setType(0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, dVar));
                return;
            }
            return;
        }
        this.eis.I(i, str);
    }
}
