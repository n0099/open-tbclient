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
    final /* synthetic */ NewSubPbActivity eye;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(NewSubPbActivity newSubPbActivity) {
        this.eye = newSubPbActivity;
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
        aoVar = this.eye.exP;
        if (aoVar != null) {
            aoVar5 = this.eye.exP;
            aoVar5.aOb();
        }
        bVar = this.eye.eyb;
        if (bVar != null) {
            bVar2 = this.eye.eyb;
            if (bVar2.aNI()) {
                bVar3 = this.eye.eyb;
                bVar3.oQ(w.e.cp_bg_line_k_alpha40);
            }
        }
        if (z) {
            aoVar2 = this.eye.exP;
            aoVar2.hideNoDataView();
            if (nVar != null) {
                if (nVar.aJj() == null) {
                    subPbModel4 = this.eye.exN;
                }
                PostData aJj = nVar.aJj();
                subPbModel = this.eye.exN;
                aJj.a(subPbModel.aOB());
                aoVar3 = this.eye.exP;
                if (aoVar3 != null) {
                    aoVar4 = this.eye.exP;
                    subPbModel2 = this.eye.exN;
                    int aIM = subPbModel2.aIM();
                    subPbModel3 = this.eye.exN;
                    aoVar4.a(nVar, aIM, subPbModel3.aOD() != null);
                    z2 = this.eye.exY;
                    if (z2) {
                        this.eye.aNN();
                        this.eye.exY = false;
                    }
                }
                com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                dVar.setData(nVar);
                nVar2 = this.eye.dnc;
                if (nVar2 != null) {
                    nVar3 = this.eye.dnc;
                    nVar3.a(nVar.avj());
                }
                dVar.setType(0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, dVar));
                return;
            }
            return;
        }
        this.eye.O(i, str);
    }
}
