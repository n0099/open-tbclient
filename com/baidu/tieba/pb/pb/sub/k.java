package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.SubPbModel;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements SubPbModel.a {
    final /* synthetic */ NewSubPbActivity erC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(NewSubPbActivity newSubPbActivity) {
        this.erC = newSubPbActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0050, code lost:
        if (r0 != null) goto L33;
     */
    @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, int i, String str, com.baidu.tieba.pb.data.j jVar) {
        ao aoVar;
        b bVar;
        ao aoVar2;
        SubPbModel subPbModel;
        ao aoVar3;
        com.baidu.tbadk.editortools.pb.n nVar;
        com.baidu.tbadk.editortools.pb.n nVar2;
        ao aoVar4;
        SubPbModel subPbModel2;
        SubPbModel subPbModel3;
        boolean z2;
        SubPbModel subPbModel4;
        b bVar2;
        b bVar3;
        ao aoVar5;
        aoVar = this.erC.ern;
        if (aoVar != null) {
            aoVar5 = this.erC.ern;
            aoVar5.aPb();
        }
        bVar = this.erC.erz;
        if (bVar != null) {
            bVar2 = this.erC.erz;
            if (bVar2.aOJ()) {
                bVar3 = this.erC.erz;
                bVar3.oI(r.e.cp_bg_line_k_alpha40);
            }
        }
        if (z) {
            aoVar2 = this.erC.ern;
            aoVar2.hideNoDataView();
            if (jVar != null) {
                if (jVar.aKw() == null) {
                    subPbModel4 = this.erC.erl;
                }
                com.baidu.tieba.tbadkCore.data.p aKw = jVar.aKw();
                subPbModel = this.erC.erl;
                aKw.a(subPbModel.aPB());
                aoVar3 = this.erC.ern;
                if (aoVar3 != null) {
                    aoVar4 = this.erC.ern;
                    subPbModel2 = this.erC.erl;
                    int aKj = subPbModel2.aKj();
                    subPbModel3 = this.erC.erl;
                    aoVar4.a(jVar, aKj, subPbModel3.aPD() != null);
                    z2 = this.erC.erw;
                    if (z2) {
                        this.erC.aOO();
                        this.erC.erw = false;
                    }
                }
                com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                dVar.setData(jVar);
                nVar = this.erC.dkr;
                if (nVar != null) {
                    nVar2 = this.erC.dkr;
                    nVar2.a(jVar.axd());
                }
                dVar.setType(0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, dVar));
                return;
            }
            return;
        }
        this.erC.L(i, str);
    }
}
