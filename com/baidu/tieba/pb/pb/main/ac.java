package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ac extends CustomMessageListener {
    final /* synthetic */ PbActivity ebT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(PbActivity pbActivity, int i) {
        super(i);
        this.ebT = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        dh dhVar;
        int i;
        ew ewVar;
        dh dhVar2;
        dh dhVar3;
        dh dhVar4;
        boolean z2;
        ew ewVar2;
        ew ewVar3;
        ew ewVar4;
        dh dhVar5;
        String aIf;
        boolean z3;
        dh dhVar6;
        ew ewVar5;
        dh dhVar7;
        ew ewVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.b.a)) {
            com.baidu.tieba.pb.b.a aVar = (com.baidu.tieba.pb.b.a) customResponsedMessage.getData();
            if (aVar.tag == this.ebT.getUniqueId()) {
                switch (aVar.ekM) {
                    case 0:
                        z3 = this.ebT.mIsLogin;
                        if (z3) {
                            dhVar6 = this.ebT.eas;
                            if (dhVar6.hH(false)) {
                                ewVar6 = this.ebT.ebb;
                                ewVar6.aKz();
                                return;
                            }
                            ewVar5 = this.ebT.ebb;
                            dhVar7 = this.ebT.eas;
                            ewVar5.m(dhVar7.getPbData());
                            return;
                        }
                        return;
                    case 1:
                        z2 = this.ebT.mIsLoading;
                        if (!z2) {
                            this.ebT.mIsLoading = true;
                            ewVar2 = this.ebT.ebb;
                            ewVar2.efS.eiW.setEnabled(false);
                            ewVar3 = this.ebT.ebb;
                            ewVar3.app();
                            this.ebT.VR();
                            ewVar4 = this.ebT.ebb;
                            ewVar4.aKy();
                            dhVar5 = this.ebT.eas;
                            aIf = this.ebT.aIf();
                            dhVar5.ol(aIf);
                            return;
                        }
                        return;
                    case 2:
                        z = this.ebT.eaM;
                        if (z) {
                            dhVar2 = this.ebT.eas;
                            boolean hostMode = dhVar2.getHostMode();
                            dhVar3 = this.ebT.eas;
                            boolean aIX = dhVar3.aIX();
                            dhVar4 = this.ebT.eas;
                            String threadID = dhVar4.getThreadID();
                            String str = aVar.postId;
                            int i2 = aVar.ekN;
                            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.ebT.getPageContext().getPageActivity());
                            pbActivityConfig.createReaderServiceCfg(threadID, str, i2, hostMode, aIX, null);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                            this.ebT.ebf = false;
                            this.ebT.finish();
                            return;
                        }
                        int i3 = aVar.ekN;
                        dhVar = this.ebT.eas;
                        if (dhVar.getHostMode()) {
                            i = i3 + 3;
                        } else {
                            i = i3 + 2;
                        }
                        ewVar = this.ebT.ebb;
                        ewVar.LN().setSelection(i);
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
