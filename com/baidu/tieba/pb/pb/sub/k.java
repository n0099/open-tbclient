package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.SubPbModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements SubPbModel.a {
    final /* synthetic */ NewSubPbActivity evm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(NewSubPbActivity newSubPbActivity) {
        this.evm = newSubPbActivity;
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
        aoVar = this.evm.euX;
        if (aoVar != null) {
            aoVar5 = this.evm.euX;
            aoVar5.aPC();
        }
        bVar = this.evm.evj;
        if (bVar != null) {
            bVar2 = this.evm.evj;
            if (bVar2.aPk()) {
                bVar3 = this.evm.evj;
                bVar3.oC(w.e.cp_bg_line_k_alpha40);
            }
        }
        if (z) {
            aoVar2 = this.evm.euX;
            aoVar2.hideNoDataView();
            if (jVar != null) {
                if (jVar.aKW() == null) {
                    subPbModel4 = this.evm.euV;
                }
                PostData aKW = jVar.aKW();
                subPbModel = this.evm.euV;
                aKW.a(subPbModel.aQc());
                aoVar3 = this.evm.euX;
                if (aoVar3 != null) {
                    aoVar4 = this.evm.euX;
                    subPbModel2 = this.evm.euV;
                    int aKI = subPbModel2.aKI();
                    subPbModel3 = this.evm.euV;
                    aoVar4.a(jVar, aKI, subPbModel3.aQe() != null);
                    z2 = this.evm.evg;
                    if (z2) {
                        this.evm.aPp();
                        this.evm.evg = false;
                    }
                }
                com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                dVar.setData(jVar);
                nVar = this.evm.dnB;
                if (nVar != null) {
                    nVar2 = this.evm.dnB;
                    nVar2.a(jVar.axt());
                }
                dVar.setType(0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, dVar));
                return;
            }
            return;
        }
        this.evm.M(i, str);
    }
}
