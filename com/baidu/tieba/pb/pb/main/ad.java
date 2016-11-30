package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ad extends CustomMessageListener {
    final /* synthetic */ PbActivity evL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(PbActivity pbActivity, int i) {
        super(i);
        this.evL = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        dj djVar;
        int i;
        ey eyVar;
        dj djVar2;
        dj djVar3;
        dj djVar4;
        boolean z2;
        ey eyVar2;
        ey eyVar3;
        ey eyVar4;
        dj djVar5;
        String aPu;
        boolean z3;
        dj djVar6;
        dj djVar7;
        ey eyVar5;
        ey eyVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.b.a)) {
            com.baidu.tieba.pb.b.a aVar = (com.baidu.tieba.pb.b.a) customResponsedMessage.getData();
            if (aVar.tag == this.evL.getUniqueId()) {
                switch (aVar.eFN) {
                    case 0:
                        z3 = this.evL.mIsLogin;
                        if (z3) {
                            djVar6 = this.evL.euf;
                            if (!djVar6.ix(false)) {
                                djVar7 = this.evL.euf;
                                if (djVar7.getPbData() != null) {
                                    eyVar5 = this.evL.euP;
                                    eyVar5.aSo();
                                    return;
                                }
                                return;
                            }
                            eyVar6 = this.evL.euP;
                            eyVar6.aSb();
                            return;
                        }
                        return;
                    case 1:
                        z2 = this.evL.mIsLoading;
                        if (!z2) {
                            this.evL.mIsLoading = true;
                            eyVar2 = this.evL.euP;
                            eyVar2.eAx.eDI.setEnabled(false);
                            eyVar3 = this.evL.euP;
                            eyVar3.awz();
                            this.evL.acp();
                            eyVar4 = this.evL.euP;
                            eyVar4.aSa();
                            djVar5 = this.evL.euf;
                            aPu = this.evL.aPu();
                            djVar5.pw(aPu);
                            return;
                        }
                        return;
                    case 2:
                        z = this.evL.euz;
                        if (z) {
                            djVar2 = this.evL.euf;
                            boolean hostMode = djVar2.getHostMode();
                            djVar3 = this.evL.euf;
                            boolean aQp = djVar3.aQp();
                            djVar4 = this.evL.euf;
                            String threadID = djVar4.getThreadID();
                            String str = aVar.postId;
                            int i2 = aVar.eFO;
                            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.evL.getPageContext().getPageActivity());
                            pbActivityConfig.createReaderServiceCfg(threadID, str, i2, hostMode, aQp, null);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                            this.evL.euV = false;
                            this.evL.finish();
                            return;
                        }
                        int i3 = aVar.eFO;
                        djVar = this.evL.euf;
                        if (djVar.getHostMode()) {
                            i = i3 + 3;
                        } else {
                            i = i3 + 2;
                        }
                        eyVar = this.evL.euP;
                        eyVar.PW().setSelection(i);
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
