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
    final /* synthetic */ NewSubPbActivity esV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(NewSubPbActivity newSubPbActivity) {
        this.esV = newSubPbActivity;
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
        aoVar = this.esV.esG;
        if (aoVar != null) {
            aoVar5 = this.esV.esG;
            aoVar5.aOB();
        }
        bVar = this.esV.esS;
        if (bVar != null) {
            bVar2 = this.esV.esS;
            if (bVar2.aOj()) {
                bVar3 = this.esV.esS;
                bVar3.ow(w.e.cp_bg_line_k_alpha40);
            }
        }
        if (z) {
            aoVar2 = this.esV.esG;
            aoVar2.hideNoDataView();
            if (jVar != null) {
                if (jVar.aJV() == null) {
                    subPbModel4 = this.esV.esE;
                }
                PostData aJV = jVar.aJV();
                subPbModel = this.esV.esE;
                aJV.a(subPbModel.aPb());
                aoVar3 = this.esV.esG;
                if (aoVar3 != null) {
                    aoVar4 = this.esV.esG;
                    subPbModel2 = this.esV.esE;
                    int aJH = subPbModel2.aJH();
                    subPbModel3 = this.esV.esE;
                    aoVar4.a(jVar, aJH, subPbModel3.aPd() != null);
                    z2 = this.esV.esP;
                    if (z2) {
                        this.esV.aOo();
                        this.esV.esP = false;
                    }
                }
                com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                dVar.setData(jVar);
                nVar = this.esV.dlk;
                if (nVar != null) {
                    nVar2 = this.esV.dlk;
                    nVar2.a(jVar.aws());
                }
                dVar.setType(0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, dVar));
                return;
            }
            return;
        }
        this.esV.M(i, str);
    }
}
