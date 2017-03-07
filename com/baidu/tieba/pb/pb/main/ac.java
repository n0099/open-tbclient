package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ac extends CustomMessageListener {
    final /* synthetic */ PbActivity elO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(PbActivity pbActivity, int i) {
        super(i);
        this.elO = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        PbModel pbModel;
        int i;
        fa faVar;
        PbModel pbModel2;
        PbModel pbModel3;
        PbModel pbModel4;
        boolean z2;
        fa faVar2;
        fa faVar3;
        fa faVar4;
        PbModel pbModel5;
        String aKB;
        boolean z3;
        PbModel pbModel6;
        PbModel pbModel7;
        fa faVar5;
        fa faVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.b.a)) {
            com.baidu.tieba.pb.b.a aVar = (com.baidu.tieba.pb.b.a) customResponsedMessage.getData();
            if (aVar.tag == this.elO.getUniqueId()) {
                switch (aVar.ewl) {
                    case 0:
                        z3 = this.elO.mIsLogin;
                        if (z3) {
                            pbModel6 = this.elO.ejZ;
                            if (!pbModel6.ip(false)) {
                                pbModel7 = this.elO.ejZ;
                                if (pbModel7.getPbData() != null) {
                                    faVar5 = this.elO.ekM;
                                    faVar5.aNs();
                                    return;
                                }
                                return;
                            }
                            faVar6 = this.elO.ekM;
                            faVar6.aNd();
                            return;
                        }
                        return;
                    case 1:
                        z2 = this.elO.mIsLoading;
                        if (!z2) {
                            this.elO.mIsLoading = true;
                            faVar2 = this.elO.ekM;
                            faVar2.eqM.eud.setEnabled(false);
                            faVar3 = this.elO.ekM;
                            faVar3.arz();
                            this.elO.YT();
                            faVar4 = this.elO.ekM;
                            faVar4.aNc();
                            pbModel5 = this.elO.ejZ;
                            aKB = this.elO.aKB();
                            pbModel5.nu(aKB);
                            return;
                        }
                        return;
                    case 2:
                        z = this.elO.eku;
                        if (z) {
                            pbModel2 = this.elO.ejZ;
                            boolean hostMode = pbModel2.getHostMode();
                            pbModel3 = this.elO.ejZ;
                            boolean aLu = pbModel3.aLu();
                            pbModel4 = this.elO.ejZ;
                            String threadID = pbModel4.getThreadID();
                            String str = aVar.postId;
                            int i2 = aVar.ewm;
                            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.elO.getPageContext().getPageActivity());
                            pbActivityConfig.createReaderServiceCfg(threadID, str, i2, hostMode, aLu, null);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                            this.elO.ekS = false;
                            this.elO.finish();
                            return;
                        }
                        int i3 = aVar.ewm;
                        pbModel = this.elO.ejZ;
                        if (pbModel.getHostMode()) {
                            i = i3 + 3;
                        } else {
                            i = i3 + 2;
                        }
                        faVar = this.elO.ekM;
                        faVar.getListView().setSelection(i);
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
