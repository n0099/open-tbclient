package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ad extends CustomMessageListener {
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(PbActivity pbActivity, int i) {
        super(i);
        this.ehy = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        PbModel pbModel;
        int i;
        fm fmVar;
        PbModel pbModel2;
        PbModel pbModel3;
        PbModel pbModel4;
        boolean z2;
        fm fmVar2;
        fm fmVar3;
        fm fmVar4;
        PbModel pbModel5;
        String aJe;
        boolean z3;
        PbModel pbModel6;
        PbModel pbModel7;
        fm fmVar5;
        fm fmVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.b.a)) {
            com.baidu.tieba.pb.b.a aVar = (com.baidu.tieba.pb.b.a) customResponsedMessage.getData();
            if (aVar.tag == this.ehy.getUniqueId()) {
                switch (aVar.esp) {
                    case 0:
                        z3 = this.ehy.mIsLogin;
                        if (z3) {
                            pbModel6 = this.ehy.efE;
                            if (!pbModel6.ic(false)) {
                                pbModel7 = this.ehy.efE;
                                if (pbModel7.getPbData() != null) {
                                    fmVar5 = this.ehy.egt;
                                    fmVar5.aLT();
                                    return;
                                }
                                return;
                            }
                            fmVar6 = this.ehy.egt;
                            fmVar6.aLE();
                            return;
                        }
                        return;
                    case 1:
                        z2 = this.ehy.mIsLoading;
                        if (!z2) {
                            this.ehy.mIsLoading = true;
                            fmVar2 = this.ehy.egt;
                            fmVar2.emS.eqb.setEnabled(false);
                            fmVar3 = this.ehy.egt;
                            fmVar3.apn();
                            this.ehy.Zo();
                            fmVar4 = this.ehy.egt;
                            fmVar4.aLD();
                            pbModel5 = this.ehy.efE;
                            aJe = this.ehy.aJe();
                            pbModel5.nI(aJe);
                            return;
                        }
                        return;
                    case 2:
                        z = this.ehy.efZ;
                        if (z) {
                            pbModel2 = this.ehy.efE;
                            boolean hostMode = pbModel2.getHostMode();
                            pbModel3 = this.ehy.efE;
                            boolean aJT = pbModel3.aJT();
                            pbModel4 = this.ehy.efE;
                            String threadID = pbModel4.getThreadID();
                            String str = aVar.postId;
                            int i2 = aVar.esq;
                            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.ehy.getPageContext().getPageActivity());
                            pbActivityConfig.createReaderServiceCfg(threadID, str, i2, hostMode, aJT, null);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                            this.ehy.egz = false;
                            this.ehy.finish();
                            return;
                        }
                        int i3 = aVar.esq;
                        pbModel = this.ehy.efE;
                        if (pbModel.getHostMode()) {
                            i = i3 + 3;
                        } else {
                            i = i3 + 2;
                        }
                        fmVar = this.ehy.egt;
                        fmVar.getListView().setSelection(i);
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
