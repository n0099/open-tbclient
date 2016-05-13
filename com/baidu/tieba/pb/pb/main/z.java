package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class z extends CustomMessageListener {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(PbActivity pbActivity, int i) {
        super(i);
        this.djE = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        cw cwVar;
        int i;
        el elVar;
        cw cwVar2;
        cw cwVar3;
        cw cwVar4;
        boolean z2;
        el elVar2;
        el elVar3;
        el elVar4;
        cw cwVar5;
        String awN;
        boolean z3;
        cw cwVar6;
        el elVar5;
        cw cwVar7;
        el elVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.b.a)) {
            com.baidu.tieba.pb.b.a aVar = (com.baidu.tieba.pb.b.a) customResponsedMessage.getData();
            if (aVar.tag == this.djE.getUniqueId()) {
                switch (aVar.drz) {
                    case 0:
                        z3 = this.djE.mIsLogin;
                        if (z3) {
                            cwVar6 = this.djE.dih;
                            if (cwVar6.gE(false)) {
                                elVar6 = this.djE.diR;
                                elVar6.aze();
                                return;
                            }
                            elVar5 = this.djE.diR;
                            cwVar7 = this.djE.dih;
                            elVar5.n(cwVar7.getPbData());
                            return;
                        }
                        return;
                    case 1:
                        z2 = this.djE.mIsLoading;
                        if (!z2) {
                            this.djE.mIsLoading = true;
                            elVar2 = this.djE.diR;
                            elVar2.dmZ.dpV.setEnabled(false);
                            elVar3 = this.djE.diR;
                            elVar3.agq();
                            this.djE.Pm();
                            elVar4 = this.djE.diR;
                            elVar4.azd();
                            cwVar5 = this.djE.dih;
                            awN = this.djE.awN();
                            cwVar5.lX(awN);
                            return;
                        }
                        return;
                    case 2:
                        z = this.djE.diA;
                        if (z) {
                            cwVar2 = this.djE.dih;
                            boolean hostMode = cwVar2.getHostMode();
                            cwVar3 = this.djE.dih;
                            boolean axE = cwVar3.axE();
                            cwVar4 = this.djE.dih;
                            String threadID = cwVar4.getThreadID();
                            String str = aVar.postId;
                            int i2 = aVar.drA;
                            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.djE.getPageContext().getPageActivity());
                            pbActivityConfig.createReaderServiceCfg(threadID, str, i2, hostMode, axE, null);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                            this.djE.diV = false;
                            this.djE.finish();
                            return;
                        }
                        int i3 = aVar.drA;
                        cwVar = this.djE.dih;
                        if (cwVar.getHostMode()) {
                            i = i3 + 3;
                        } else {
                            i = i3 + 2;
                        }
                        elVar = this.djE.diR;
                        elVar.KR().setSelection(i);
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
