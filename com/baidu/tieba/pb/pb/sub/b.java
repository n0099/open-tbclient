package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.ax;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements ax.a {
    final /* synthetic */ NewSubPbActivity evy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(NewSubPbActivity newSubPbActivity) {
        this.evy = newSubPbActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
        if (r0 != null) goto L26;
     */
    @Override // com.baidu.tieba.pb.pb.sub.ax.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, int i, String str, com.baidu.tieba.pb.data.m mVar) {
        ag agVar;
        ag agVar2;
        ax axVar;
        ag agVar3;
        com.baidu.tbadk.editortools.d.p pVar;
        com.baidu.tbadk.editortools.d.p pVar2;
        ag agVar4;
        ax axVar2;
        ax axVar3;
        ax axVar4;
        ag agVar5;
        agVar = this.evy.evn;
        if (agVar != null) {
            agVar5 = this.evy.evn;
            agVar5.aQt();
        }
        if (z) {
            agVar2 = this.evy.evn;
            agVar2.hideNoDataView();
            if (mVar != null) {
                if (mVar.aMh() == null) {
                    axVar4 = this.evy.evl;
                }
                com.baidu.tieba.tbadkCore.data.q aMh = mVar.aMh();
                axVar = this.evy.evl;
                aMh.a(axVar.aQY());
                agVar3 = this.evy.evn;
                if (agVar3 != null) {
                    agVar4 = this.evy.evn;
                    axVar2 = this.evy.evl;
                    int aLX = axVar2.aLX();
                    axVar3 = this.evy.evl;
                    agVar4.a(mVar, aLX, axVar3.aRa() != null);
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(mVar);
                pVar = this.evy.dtc;
                if (pVar != null) {
                    pVar2 = this.evy.dtc;
                    pVar2.a(mVar.getAntiData());
                }
                eVar.setType(0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                return;
            }
            return;
        }
        this.evy.showToast(str);
        this.evy.M(i, str);
    }
}
