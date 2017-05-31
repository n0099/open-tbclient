package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ah extends CustomMessageListener {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah(PbActivity pbActivity, int i) {
        super(i);
        this.enc = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        PbModel pbModel;
        int i;
        fx fxVar;
        PbModel pbModel2;
        PbModel pbModel3;
        PbModel pbModel4;
        boolean z2;
        fx fxVar2;
        fx fxVar3;
        fx fxVar4;
        PbModel pbModel5;
        String aJW;
        boolean z3;
        PbModel pbModel6;
        PbModel pbModel7;
        fx fxVar5;
        fx fxVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.b.a)) {
            com.baidu.tieba.pb.b.a aVar = (com.baidu.tieba.pb.b.a) customResponsedMessage.getData();
            if (aVar.tag == this.enc.getUniqueId()) {
                switch (aVar.ezB) {
                    case 0:
                        z3 = this.enc.mIsLogin;
                        if (z3) {
                            pbModel6 = this.enc.ele;
                            if (!pbModel6.ir(false)) {
                                pbModel7 = this.enc.ele;
                                if (pbModel7.getPbData() != null) {
                                    fxVar5 = this.enc.elU;
                                    fxVar5.aMN();
                                    return;
                                }
                                return;
                            }
                            fxVar6 = this.enc.elU;
                            fxVar6.aMA();
                            return;
                        }
                        return;
                    case 1:
                        z2 = this.enc.mIsLoading;
                        if (!z2) {
                            this.enc.mIsLoading = true;
                            fxVar2 = this.enc.elU;
                            fxVar2.esG.exj.setEnabled(false);
                            fxVar3 = this.enc.elU;
                            fxVar3.aqn();
                            this.enc.aas();
                            fxVar4 = this.enc.elU;
                            fxVar4.aMz();
                            pbModel5 = this.enc.ele;
                            aJW = this.enc.aJW();
                            pbModel5.nU(aJW);
                            return;
                        }
                        return;
                    case 2:
                        z = this.enc.ely;
                        if (z) {
                            pbModel2 = this.enc.ele;
                            boolean hostMode = pbModel2.getHostMode();
                            pbModel3 = this.enc.ele;
                            boolean aKN = pbModel3.aKN();
                            pbModel4 = this.enc.ele;
                            String threadID = pbModel4.getThreadID();
                            String str = aVar.postId;
                            int i2 = aVar.ezC;
                            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.enc.getPageContext().getPageActivity());
                            pbActivityConfig.createReaderServiceCfg(threadID, str, i2, hostMode, aKN, null);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                            this.enc.ema = false;
                            this.enc.finish();
                            return;
                        }
                        int i3 = aVar.ezC;
                        pbModel = this.enc.ele;
                        if (pbModel.getHostMode()) {
                            i = i3 + 3;
                        } else {
                            i = i3 + 2;
                        }
                        fxVar = this.enc.elU;
                        fxVar.getListView().setSelection(i);
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
