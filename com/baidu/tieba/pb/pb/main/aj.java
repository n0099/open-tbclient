package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class aj extends CustomMessageListener {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(PbActivity pbActivity, int i) {
        super(i);
        this.ewh = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        PbModel pbModel;
        int i;
        gg ggVar;
        PbModel pbModel2;
        PbModel pbModel3;
        PbModel pbModel4;
        boolean z2;
        gg ggVar2;
        gg ggVar3;
        gg ggVar4;
        PbModel pbModel5;
        String aNT;
        boolean z3;
        PbModel pbModel6;
        PbModel pbModel7;
        gg ggVar5;
        gg ggVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.b.a)) {
            com.baidu.tieba.pb.b.a aVar = (com.baidu.tieba.pb.b.a) customResponsedMessage.getData();
            if (aVar.tag == this.ewh.getUniqueId()) {
                switch (aVar.eIX) {
                    case 0:
                        z3 = this.ewh.mIsLogin;
                        if (z3) {
                            pbModel6 = this.ewh.eue;
                            if (!pbModel6.iN(false)) {
                                pbModel7 = this.ewh.eue;
                                if (pbModel7.getPbData() != null) {
                                    ggVar5 = this.ewh.euU;
                                    ggVar5.aQL();
                                    return;
                                }
                                return;
                            }
                            ggVar6 = this.ewh.euU;
                            ggVar6.aQy();
                            return;
                        }
                        return;
                    case 1:
                        z2 = this.ewh.mIsLoading;
                        if (!z2) {
                            this.ewh.mIsLoading = true;
                            ggVar2 = this.ewh.euU;
                            ggVar2.eBR.eGI.setEnabled(false);
                            ggVar3 = this.ewh.euU;
                            ggVar3.atY();
                            this.ewh.aei();
                            ggVar4 = this.ewh.euU;
                            ggVar4.aQx();
                            pbModel5 = this.ewh.eue;
                            aNT = this.ewh.aNT();
                            pbModel5.oP(aNT);
                            return;
                        }
                        return;
                    case 2:
                        z = this.ewh.euy;
                        if (z) {
                            pbModel2 = this.ewh.eue;
                            boolean hostMode = pbModel2.getHostMode();
                            pbModel3 = this.ewh.eue;
                            boolean aOK = pbModel3.aOK();
                            pbModel4 = this.ewh.eue;
                            String threadID = pbModel4.getThreadID();
                            String str = aVar.postId;
                            int i2 = aVar.eIY;
                            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.ewh.getPageContext().getPageActivity());
                            pbActivityConfig.createReaderServiceCfg(threadID, str, i2, hostMode, aOK, null);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                            this.ewh.eva = false;
                            this.ewh.finish();
                            return;
                        }
                        int i3 = aVar.eIY;
                        pbModel = this.ewh.eue;
                        if (pbModel.getHostMode()) {
                            i = i3 + 3;
                        } else {
                            i = i3 + 2;
                        }
                        ggVar = this.ewh.euU;
                        ggVar.getListView().setSelection(i);
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
