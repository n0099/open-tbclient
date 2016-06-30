package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ac extends CustomMessageListener {
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(PbActivity pbActivity, int i) {
        super(i);
        this.dPF = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        dg dgVar;
        int i;
        es esVar;
        dg dgVar2;
        dg dgVar3;
        dg dgVar4;
        boolean z2;
        es esVar2;
        es esVar3;
        es esVar4;
        dg dgVar5;
        String aEU;
        boolean z3;
        dg dgVar6;
        es esVar5;
        dg dgVar7;
        es esVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.b.a)) {
            com.baidu.tieba.pb.b.a aVar = (com.baidu.tieba.pb.b.a) customResponsedMessage.getData();
            if (aVar.tag == this.dPF.getUniqueId()) {
                switch (aVar.dYk) {
                    case 0:
                        z3 = this.dPF.mIsLogin;
                        if (z3) {
                            dgVar6 = this.dPF.dOf;
                            if (dgVar6.hw(false)) {
                                esVar6 = this.dPF.dOO;
                                esVar6.aHo();
                                return;
                            }
                            esVar5 = this.dPF.dOO;
                            dgVar7 = this.dPF.dOf;
                            esVar5.m(dgVar7.getPbData());
                            return;
                        }
                        return;
                    case 1:
                        z2 = this.dPF.mIsLoading;
                        if (!z2) {
                            this.dPF.mIsLoading = true;
                            esVar2 = this.dPF.dOO;
                            esVar2.dTq.dWt.setEnabled(false);
                            esVar3 = this.dPF.dOO;
                            esVar3.aoD();
                            this.dPF.UR();
                            esVar4 = this.dPF.dOO;
                            esVar4.aHn();
                            dgVar5 = this.dPF.dOf;
                            aEU = this.dPF.aEU();
                            dgVar5.ny(aEU);
                            return;
                        }
                        return;
                    case 2:
                        z = this.dPF.dOz;
                        if (z) {
                            dgVar2 = this.dPF.dOf;
                            boolean hostMode = dgVar2.getHostMode();
                            dgVar3 = this.dPF.dOf;
                            boolean aFM = dgVar3.aFM();
                            dgVar4 = this.dPF.dOf;
                            String threadID = dgVar4.getThreadID();
                            String str = aVar.postId;
                            int i2 = aVar.dYl;
                            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.dPF.getPageContext().getPageActivity());
                            pbActivityConfig.createReaderServiceCfg(threadID, str, i2, hostMode, aFM, null);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                            this.dPF.dOS = false;
                            this.dPF.finish();
                            return;
                        }
                        int i3 = aVar.dYl;
                        dgVar = this.dPF.dOf;
                        if (dgVar.getHostMode()) {
                            i = i3 + 3;
                        } else {
                            i = i3 + 2;
                        }
                        esVar = this.dPF.dOO;
                        esVar.LO().setSelection(i);
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
