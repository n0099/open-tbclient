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
    final /* synthetic */ NewSubPbActivity eHC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(NewSubPbActivity newSubPbActivity) {
        this.eHC = newSubPbActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0050, code lost:
        if (r0 != null) goto L33;
     */
    @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, int i, String str, com.baidu.tieba.pb.data.n nVar) {
        ao aoVar;
        b bVar;
        ao aoVar2;
        SubPbModel subPbModel;
        ao aoVar3;
        com.baidu.tbadk.editortools.pb.n nVar2;
        com.baidu.tbadk.editortools.pb.n nVar3;
        ao aoVar4;
        SubPbModel subPbModel2;
        SubPbModel subPbModel3;
        boolean z2;
        SubPbModel subPbModel4;
        b bVar2;
        b bVar3;
        ao aoVar5;
        aoVar = this.eHC.eHn;
        if (aoVar != null) {
            aoVar5 = this.eHC.eHn;
            aoVar5.aSa();
        }
        bVar = this.eHC.eHz;
        if (bVar != null) {
            bVar2 = this.eHC.eHz;
            if (bVar2.aRI()) {
                bVar3 = this.eHC.eHz;
                bVar3.pj(w.e.cp_bg_line_k_alpha40);
            }
        }
        if (z) {
            aoVar2 = this.eHC.eHn;
            aoVar2.hideNoDataView();
            if (nVar != null) {
                if (nVar.aNd() == null) {
                    subPbModel4 = this.eHC.eHl;
                }
                PostData aNd = nVar.aNd();
                subPbModel = this.eHC.eHl;
                aNd.a(subPbModel.aSA());
                aoVar3 = this.eHC.eHn;
                if (aoVar3 != null) {
                    aoVar4 = this.eHC.eHn;
                    subPbModel2 = this.eHC.eHl;
                    int aMG = subPbModel2.aMG();
                    subPbModel3 = this.eHC.eHl;
                    aoVar4.a(nVar, aMG, subPbModel3.aSC() != null);
                    z2 = this.eHC.eHw;
                    if (z2) {
                        this.eHC.aRN();
                        this.eHC.eHw = false;
                    }
                }
                com.baidu.tieba.pb.h hVar = new com.baidu.tieba.pb.h();
                hVar.setData(nVar);
                nVar2 = this.eHC.duY;
                if (nVar2 != null) {
                    nVar3 = this.eHC.duY;
                    nVar3.a(nVar.azh());
                }
                hVar.setType(0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, hVar));
                return;
            }
            return;
        }
        this.eHC.R(i, str);
    }
}
