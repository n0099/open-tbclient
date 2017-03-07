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
    final /* synthetic */ NewSubPbActivity euQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(NewSubPbActivity newSubPbActivity) {
        this.euQ = newSubPbActivity;
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
        aoVar = this.euQ.euB;
        if (aoVar != null) {
            aoVar5 = this.euQ.euB;
            aoVar5.aOs();
        }
        bVar = this.euQ.euN;
        if (bVar != null) {
            bVar2 = this.euQ.euN;
            if (bVar2.aOa()) {
                bVar3 = this.euQ.euN;
                bVar3.oy(w.e.cp_bg_line_k_alpha40);
            }
        }
        if (z) {
            aoVar2 = this.euQ.euB;
            aoVar2.hideNoDataView();
            if (jVar != null) {
                if (jVar.aJO() == null) {
                    subPbModel4 = this.euQ.euz;
                }
                PostData aJO = jVar.aJO();
                subPbModel = this.euQ.euz;
                aJO.a(subPbModel.aOS());
                aoVar3 = this.euQ.euB;
                if (aoVar3 != null) {
                    aoVar4 = this.euQ.euB;
                    subPbModel2 = this.euQ.euz;
                    int aJA = subPbModel2.aJA();
                    subPbModel3 = this.euQ.euz;
                    aoVar4.a(jVar, aJA, subPbModel3.aOU() != null);
                    z2 = this.euQ.euK;
                    if (z2) {
                        this.euQ.aOf();
                        this.euQ.euK = false;
                    }
                }
                com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                dVar.setData(jVar);
                nVar = this.euQ.dmL;
                if (nVar != null) {
                    nVar2 = this.euQ.dmL;
                    nVar2.a(jVar.awz());
                }
                dVar.setType(0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, dVar));
                return;
            }
            return;
        }
        this.euQ.M(i, str);
    }
}
