package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ag extends CustomMessageListener {
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(PbActivity pbActivity, int i) {
        super(i);
        this.dht = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        df dfVar;
        int i;
        eu euVar;
        df dfVar2;
        df dfVar3;
        df dfVar4;
        boolean z2;
        eu euVar2;
        eu euVar3;
        eu euVar4;
        df dfVar5;
        String awC;
        boolean z3;
        df dfVar6;
        eu euVar5;
        df dfVar7;
        eu euVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.b.a)) {
            com.baidu.tieba.pb.b.a aVar = (com.baidu.tieba.pb.b.a) customResponsedMessage.getData();
            if (aVar.tag == this.dht.getUniqueId()) {
                switch (aVar.dpQ) {
                    case 0:
                        z3 = this.dht.mIsLogin;
                        if (z3) {
                            dfVar6 = this.dht.dfV;
                            if (dfVar6.gb(false)) {
                                euVar6 = this.dht.dgF;
                                euVar6.ayF();
                                return;
                            }
                            euVar5 = this.dht.dgF;
                            dfVar7 = this.dht.dfV;
                            euVar5.l(dfVar7.getPbData());
                            return;
                        }
                        return;
                    case 1:
                        z2 = this.dht.mIsLoading;
                        if (!z2) {
                            this.dht.mIsLoading = true;
                            euVar2 = this.dht.dgF;
                            euVar2.dkF.dnG.setEnabled(false);
                            euVar3 = this.dht.dgF;
                            euVar3.agh();
                            this.dht.Qn();
                            euVar4 = this.dht.dgF;
                            euVar4.ayE();
                            dfVar5 = this.dht.dfV;
                            awC = this.dht.awC();
                            dfVar5.lX(awC);
                            return;
                        }
                        return;
                    case 2:
                        z = this.dht.dgn;
                        if (z) {
                            dfVar2 = this.dht.dfV;
                            boolean hostMode = dfVar2.getHostMode();
                            dfVar3 = this.dht.dfV;
                            boolean axe = dfVar3.axe();
                            dfVar4 = this.dht.dfV;
                            String threadID = dfVar4.getThreadID();
                            String str = aVar.postId;
                            int i2 = aVar.dpR;
                            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.dht.getPageContext().getPageActivity());
                            pbActivityConfig.createReaderServiceCfg(threadID, str, i2, hostMode, axe, null);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                            this.dht.dgK = false;
                            this.dht.finish();
                            return;
                        }
                        int i3 = aVar.dpR;
                        dfVar = this.dht.dfV;
                        if (dfVar.getHostMode()) {
                            i = i3 + 3;
                        } else {
                            i = i3 + 2;
                        }
                        euVar = this.dht.dgF;
                        euVar.Mg().setSelection(i);
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
