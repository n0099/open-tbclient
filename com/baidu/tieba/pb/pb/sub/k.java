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
    final /* synthetic */ NewSubPbActivity eqU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(NewSubPbActivity newSubPbActivity) {
        this.eqU = newSubPbActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0050, code lost:
        if (r0 != null) goto L33;
     */
    @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, int i, String str, com.baidu.tieba.pb.data.l lVar) {
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
        aoVar = this.eqU.eqF;
        if (aoVar != null) {
            aoVar5 = this.eqU.eqF;
            aoVar5.aMS();
        }
        bVar = this.eqU.eqR;
        if (bVar != null) {
            bVar2 = this.eqU.eqR;
            if (bVar2.aMz()) {
                bVar3 = this.eqU.eqR;
                bVar3.os(w.e.cp_bg_line_k_alpha40);
            }
        }
        if (z) {
            aoVar2 = this.eqU.eqF;
            aoVar2.hideNoDataView();
            if (lVar != null) {
                if (lVar.aIr() == null) {
                    subPbModel4 = this.eqU.eqD;
                }
                PostData aIr = lVar.aIr();
                subPbModel = this.eqU.eqD;
                aIr.a(subPbModel.aNs());
                aoVar3 = this.eqU.eqF;
                if (aoVar3 != null) {
                    aoVar4 = this.eqU.eqF;
                    subPbModel2 = this.eqU.eqD;
                    int aHR = subPbModel2.aHR();
                    subPbModel3 = this.eqU.eqD;
                    aoVar4.a(lVar, aHR, subPbModel3.aNu() != null);
                    z2 = this.eqU.eqO;
                    if (z2) {
                        this.eqU.aME();
                        this.eqU.eqO = false;
                    }
                }
                com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                dVar.setData(lVar);
                nVar = this.eqU.dhG;
                if (nVar != null) {
                    nVar2 = this.eqU.dhG;
                    nVar2.a(lVar.aup());
                }
                dVar.setType(0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, dVar));
                return;
            }
            return;
        }
        this.eqU.N(i, str);
    }
}
