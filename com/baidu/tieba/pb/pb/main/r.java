package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class r extends CustomMessageListener {
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(PbActivity pbActivity, int i) {
        super(i);
        this.cNq = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        cm cmVar;
        int i;
        dz dzVar;
        cm cmVar2;
        cm cmVar3;
        cm cmVar4;
        boolean z2;
        dz dzVar2;
        dz dzVar3;
        dz dzVar4;
        cm cmVar5;
        String apB;
        boolean z3;
        cm cmVar6;
        dz dzVar5;
        cm cmVar7;
        dz dzVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.c.a)) {
            com.baidu.tieba.pb.c.a aVar = (com.baidu.tieba.pb.c.a) customResponsedMessage.getData();
            if (aVar.tag == this.cNq.getUniqueId()) {
                switch (aVar.cUV) {
                    case 0:
                        z3 = this.cNq.mIsLogin;
                        if (z3) {
                            cmVar6 = this.cNq.cMF;
                            if (cmVar6.fr(false)) {
                                dzVar6 = this.cNq.cMK;
                                dzVar6.ari();
                                return;
                            }
                            dzVar5 = this.cNq.cMK;
                            cmVar7 = this.cNq.cMF;
                            dzVar5.l(cmVar7.getPbData());
                            return;
                        }
                        return;
                    case 1:
                        z2 = this.cNq.mIsLoading;
                        if (!z2) {
                            this.cNq.mIsLoading = true;
                            dzVar2 = this.cNq.cMK;
                            dzVar2.cQn.cSM.setEnabled(false);
                            dzVar3 = this.cNq.cMK;
                            dzVar3.acM();
                            this.cNq.Oy();
                            dzVar4 = this.cNq.cMK;
                            dzVar4.arh();
                            cmVar5 = this.cNq.cMF;
                            apB = this.cNq.apB();
                            cmVar5.kK(apB);
                            return;
                        }
                        return;
                    case 2:
                        z = this.cNq.cMt;
                        if (z) {
                            cmVar2 = this.cNq.cMF;
                            boolean hostMode = cmVar2.getHostMode();
                            cmVar3 = this.cNq.cMF;
                            boolean apP = cmVar3.apP();
                            cmVar4 = this.cNq.cMF;
                            String threadID = cmVar4.getThreadID();
                            String str = aVar.postId;
                            int i2 = aVar.cUW;
                            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.cNq.getPageContext().getPageActivity());
                            pbActivityConfig.createReaderServiceCfg(threadID, str, i2, hostMode, apP, null);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                            this.cNq.cMP = false;
                            this.cNq.finish();
                            return;
                        }
                        int i3 = aVar.cUW;
                        cmVar = this.cNq.cMF;
                        if (cmVar.getHostMode()) {
                            i = i3 + 3;
                        } else {
                            i = i3 + 2;
                        }
                        dzVar = this.cNq.cMK;
                        dzVar.KM().setSelection(i);
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
