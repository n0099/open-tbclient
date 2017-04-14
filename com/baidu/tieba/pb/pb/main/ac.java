package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ac extends CustomMessageListener {
    final /* synthetic */ PbActivity ejU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(PbActivity pbActivity, int i) {
        super(i);
        this.ejU = pbActivity;
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
        String aKH;
        boolean z3;
        PbModel pbModel6;
        PbModel pbModel7;
        ey eyVar5;
        ey eyVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.b.a)) {
            com.baidu.tieba.pb.b.a aVar = (com.baidu.tieba.pb.b.a) customResponsedMessage.getData();
            if (aVar.tag == this.ejU.getUniqueId()) {
                switch (aVar.euq) {
                    case 0:
                        z3 = this.ejU.mIsLogin;
                        if (z3) {
                            pbModel6 = this.ejU.eif;
                            if (!pbModel6.io(false)) {
                                pbModel7 = this.ejU.eif;
                                if (pbModel7.getPbData() != null) {
                                    eyVar5 = this.ejU.eiS;
                                    eyVar5.aNB();
                                    return;
                                }
                                return;
                            }
                            eyVar6 = this.ejU.eiS;
                            eyVar6.aNm();
                            return;
                        }
                        return;
                    case 1:
                        z2 = this.ejU.mIsLoading;
                        if (!z2) {
                            this.ejU.mIsLoading = true;
                            eyVar2 = this.ejU.eiS;
                            eyVar2.eoV.esg.setEnabled(false);
                            eyVar3 = this.ejU.eiS;
                            eyVar3.ars();
                            this.ejU.Zp();
                            eyVar4 = this.ejU.eiS;
                            eyVar4.aNl();
                            pbModel5 = this.ejU.eif;
                            aKH = this.ejU.aKH();
                            pbModel5.nA(aKH);
                            return;
                        }
                        return;
                    case 2:
                        z = this.ejU.eiA;
                        if (z) {
                            pbModel2 = this.ejU.eif;
                            boolean hostMode = pbModel2.getHostMode();
                            pbModel3 = this.ejU.eif;
                            boolean aLC = pbModel3.aLC();
                            pbModel4 = this.ejU.eif;
                            String threadID = pbModel4.getThreadID();
                            String str = aVar.postId;
                            int i2 = aVar.eur;
                            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.ejU.getPageContext().getPageActivity());
                            pbActivityConfig.createReaderServiceCfg(threadID, str, i2, hostMode, aLC, null);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                            this.ejU.eiY = false;
                            this.ejU.finish();
                            return;
                        }
                        int i3 = aVar.eur;
                        pbModel = this.ejU.eif;
                        if (pbModel.getHostMode()) {
                            i = i3 + 3;
                        } else {
                            i = i3 + 2;
                        }
                        eyVar = this.ejU.eiS;
                        eyVar.getListView().setSelection(i);
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
