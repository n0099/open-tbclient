package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ac extends CustomMessageListener {
    final /* synthetic */ PbActivity eah;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(PbActivity pbActivity, int i) {
        super(i);
        this.eah = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        dc dcVar;
        int i;
        er erVar;
        dc dcVar2;
        dc dcVar3;
        dc dcVar4;
        boolean z2;
        er erVar2;
        er erVar3;
        er erVar4;
        dc dcVar5;
        String aJt;
        boolean z3;
        dc dcVar6;
        dc dcVar7;
        er erVar5;
        er erVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.b.a)) {
            com.baidu.tieba.pb.b.a aVar = (com.baidu.tieba.pb.b.a) customResponsedMessage.getData();
            if (aVar.tag == this.eah.getUniqueId()) {
                switch (aVar.ejN) {
                    case 0:
                        z3 = this.eah.mIsLogin;
                        if (z3) {
                            dcVar6 = this.eah.dYA;
                            if (!dcVar6.ik(false)) {
                                dcVar7 = this.eah.dYA;
                                if (dcVar7.getPbData() != null) {
                                    erVar5 = this.eah.dZk;
                                    erVar5.aMi();
                                    return;
                                }
                                return;
                            }
                            erVar6 = this.eah.dZk;
                            erVar6.aLV();
                            return;
                        }
                        return;
                    case 1:
                        z2 = this.eah.mIsLoading;
                        if (!z2) {
                            this.eah.mIsLoading = true;
                            erVar2 = this.eah.dZk;
                            erVar2.eeG.ehJ.setEnabled(false);
                            erVar3 = this.eah.dZk;
                            erVar3.aqY();
                            this.eah.WD();
                            erVar4 = this.eah.dZk;
                            erVar4.aLU();
                            dcVar5 = this.eah.dYA;
                            aJt = this.eah.aJt();
                            dcVar5.nW(aJt);
                            return;
                        }
                        return;
                    case 2:
                        z = this.eah.dYU;
                        if (z) {
                            dcVar2 = this.eah.dYA;
                            boolean hostMode = dcVar2.getHostMode();
                            dcVar3 = this.eah.dYA;
                            boolean aKl = dcVar3.aKl();
                            dcVar4 = this.eah.dYA;
                            String threadID = dcVar4.getThreadID();
                            String str = aVar.postId;
                            int i2 = aVar.ejO;
                            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.eah.getPageContext().getPageActivity());
                            pbActivityConfig.createReaderServiceCfg(threadID, str, i2, hostMode, aKl, null);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                            this.eah.dZq = false;
                            this.eah.finish();
                            return;
                        }
                        int i3 = aVar.ejO;
                        dcVar = this.eah.dYA;
                        if (dcVar.getHostMode()) {
                            i = i3 + 3;
                        } else {
                            i = i3 + 2;
                        }
                        erVar = this.eah.dZk;
                        erVar.Pv().setSelection(i);
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
