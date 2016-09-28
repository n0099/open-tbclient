package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ad extends CustomMessageListener {
    final /* synthetic */ PbActivity eqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(PbActivity pbActivity, int i) {
        super(i);
        this.eqa = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        dh dhVar;
        int i;
        ex exVar;
        dh dhVar2;
        dh dhVar3;
        dh dhVar4;
        boolean z2;
        ex exVar2;
        ex exVar3;
        ex exVar4;
        dh dhVar5;
        String aND;
        boolean z3;
        dh dhVar6;
        ex exVar5;
        dh dhVar7;
        ex exVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.b.a)) {
            com.baidu.tieba.pb.b.a aVar = (com.baidu.tieba.pb.b.a) customResponsedMessage.getData();
            if (aVar.tag == this.eqa.getUniqueId()) {
                switch (aVar.ezc) {
                    case 0:
                        z3 = this.eqa.mIsLogin;
                        if (z3) {
                            dhVar6 = this.eqa.eov;
                            if (dhVar6.m17if(false)) {
                                exVar6 = this.eqa.epe;
                                exVar6.aPZ();
                                return;
                            }
                            exVar5 = this.eqa.epe;
                            dhVar7 = this.eqa.eov;
                            exVar5.l(dhVar7.getPbData());
                            return;
                        }
                        return;
                    case 1:
                        z2 = this.eqa.mIsLoading;
                        if (!z2) {
                            this.eqa.mIsLoading = true;
                            exVar2 = this.eqa.epe;
                            exVar2.eug.exj.setEnabled(false);
                            exVar3 = this.eqa.epe;
                            exVar3.auC();
                            this.eqa.abb();
                            exVar4 = this.eqa.epe;
                            exVar4.aPY();
                            dhVar5 = this.eqa.eov;
                            aND = this.eqa.aND();
                            dhVar5.pj(aND);
                            return;
                        }
                        return;
                    case 2:
                        z = this.eqa.eoP;
                        if (z) {
                            dhVar2 = this.eqa.eov;
                            boolean hostMode = dhVar2.getHostMode();
                            dhVar3 = this.eqa.eov;
                            boolean aOw = dhVar3.aOw();
                            dhVar4 = this.eqa.eov;
                            String threadID = dhVar4.getThreadID();
                            String str = aVar.postId;
                            int i2 = aVar.ezd;
                            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.eqa.getPageContext().getPageActivity());
                            pbActivityConfig.createReaderServiceCfg(threadID, str, i2, hostMode, aOw, null);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                            this.eqa.epk = false;
                            this.eqa.finish();
                            return;
                        }
                        int i3 = aVar.ezd;
                        dhVar = this.eqa.eov;
                        if (dhVar.getHostMode()) {
                            i = i3 + 3;
                        } else {
                            i = i3 + 2;
                        }
                        exVar = this.eqa.epe;
                        exVar.OU().setSelection(i);
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
