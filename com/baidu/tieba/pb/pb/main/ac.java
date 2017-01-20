package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ac extends CustomMessageListener {
    final /* synthetic */ PbActivity eiV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(PbActivity pbActivity, int i) {
        super(i);
        this.eiV = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        PbModel pbModel;
        int i;
        ez ezVar;
        PbModel pbModel2;
        PbModel pbModel3;
        PbModel pbModel4;
        boolean z2;
        ez ezVar2;
        ez ezVar3;
        ez ezVar4;
        PbModel pbModel5;
        String aLg;
        boolean z3;
        PbModel pbModel6;
        PbModel pbModel7;
        ez ezVar5;
        ez ezVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.b.a)) {
            com.baidu.tieba.pb.b.a aVar = (com.baidu.tieba.pb.b.a) customResponsedMessage.getData();
            if (aVar.tag == this.eiV.getUniqueId()) {
                switch (aVar.esX) {
                    case 0:
                        z3 = this.eiV.mIsLogin;
                        if (z3) {
                            pbModel6 = this.eiV.ehh;
                            if (!pbModel6.iu(false)) {
                                pbModel7 = this.eiV.ehh;
                                if (pbModel7.getPbData() != null) {
                                    ezVar5 = this.eiV.ehV;
                                    ezVar5.aNY();
                                    return;
                                }
                                return;
                            }
                            ezVar6 = this.eiV.ehV;
                            ezVar6.aNK();
                            return;
                        }
                        return;
                    case 1:
                        z2 = this.eiV.mIsLoading;
                        if (!z2) {
                            this.eiV.mIsLoading = true;
                            ezVar2 = this.eiV.ehV;
                            ezVar2.enK.eqS.setEnabled(false);
                            ezVar3 = this.eiV.ehV;
                            ezVar3.ase();
                            this.eiV.XU();
                            ezVar4 = this.eiV.ehV;
                            ezVar4.aNJ();
                            pbModel5 = this.eiV.ehh;
                            aLg = this.eiV.aLg();
                            pbModel5.on(aLg);
                            return;
                        }
                        return;
                    case 2:
                        z = this.eiV.ehC;
                        if (z) {
                            pbModel2 = this.eiV.ehh;
                            boolean hostMode = pbModel2.getHostMode();
                            pbModel3 = this.eiV.ehh;
                            boolean aLY = pbModel3.aLY();
                            pbModel4 = this.eiV.ehh;
                            String threadID = pbModel4.getThreadID();
                            String str = aVar.postId;
                            int i2 = aVar.esY;
                            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.eiV.getPageContext().getPageActivity());
                            pbActivityConfig.createReaderServiceCfg(threadID, str, i2, hostMode, aLY, null);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                            this.eiV.eib = false;
                            this.eiV.finish();
                            return;
                        }
                        int i3 = aVar.esY;
                        pbModel = this.eiV.ehh;
                        if (pbModel.getHostMode()) {
                            i = i3 + 3;
                        } else {
                            i = i3 + 2;
                        }
                        ezVar = this.eiV.ehV;
                        ezVar.getListView().setSelection(i);
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
