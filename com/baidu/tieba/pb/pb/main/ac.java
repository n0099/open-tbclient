package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ac extends CustomMessageListener {
    final /* synthetic */ PbActivity emk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(PbActivity pbActivity, int i) {
        super(i);
        this.emk = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        PbModel pbModel;
        int i;
        ey eyVar;
        PbModel pbModel2;
        PbModel pbModel3;
        PbModel pbModel4;
        boolean z2;
        ey eyVar2;
        ey eyVar3;
        ey eyVar4;
        PbModel pbModel5;
        String aLH;
        boolean z3;
        PbModel pbModel6;
        PbModel pbModel7;
        ey eyVar5;
        ey eyVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.b.a)) {
            com.baidu.tieba.pb.b.a aVar = (com.baidu.tieba.pb.b.a) customResponsedMessage.getData();
            if (aVar.tag == this.emk.getUniqueId()) {
                switch (aVar.ewG) {
                    case 0:
                        z3 = this.emk.mIsLogin;
                        if (z3) {
                            pbModel6 = this.emk.ekv;
                            if (!pbModel6.iy(false)) {
                                pbModel7 = this.emk.ekv;
                                if (pbModel7.getPbData() != null) {
                                    eyVar5 = this.emk.eli;
                                    eyVar5.aOC();
                                    return;
                                }
                                return;
                            }
                            eyVar6 = this.emk.eli;
                            eyVar6.aOn();
                            return;
                        }
                        return;
                    case 1:
                        z2 = this.emk.mIsLoading;
                        if (!z2) {
                            this.emk.mIsLoading = true;
                            eyVar2 = this.emk.eli;
                            eyVar2.erm.euy.setEnabled(false);
                            eyVar3 = this.emk.eli;
                            eyVar3.ast();
                            this.emk.aaq();
                            eyVar4 = this.emk.eli;
                            eyVar4.aOm();
                            pbModel5 = this.emk.ekv;
                            aLH = this.emk.aLH();
                            pbModel5.nB(aLH);
                            return;
                        }
                        return;
                    case 2:
                        z = this.emk.ekQ;
                        if (z) {
                            pbModel2 = this.emk.ekv;
                            boolean hostMode = pbModel2.getHostMode();
                            pbModel3 = this.emk.ekv;
                            boolean aMD = pbModel3.aMD();
                            pbModel4 = this.emk.ekv;
                            String threadID = pbModel4.getThreadID();
                            String str = aVar.postId;
                            int i2 = aVar.ewH;
                            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.emk.getPageContext().getPageActivity());
                            pbActivityConfig.createReaderServiceCfg(threadID, str, i2, hostMode, aMD, null);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                            this.emk.elo = false;
                            this.emk.finish();
                            return;
                        }
                        int i3 = aVar.ewH;
                        pbModel = this.emk.ekv;
                        if (pbModel.getHostMode()) {
                            i = i3 + 3;
                        } else {
                            i = i3 + 2;
                        }
                        eyVar = this.emk.eli;
                        eyVar.getListView().setSelection(i);
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
