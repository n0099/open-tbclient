package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ad extends CustomMessageListener {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(PbActivity pbActivity, int i) {
        super(i);
        this.eob = pbActivity;
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
        String aMX;
        boolean z3;
        dh dhVar6;
        ex exVar5;
        dh dhVar7;
        ex exVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.b.a)) {
            com.baidu.tieba.pb.b.a aVar = (com.baidu.tieba.pb.b.a) customResponsedMessage.getData();
            if (aVar.tag == this.eob.getUniqueId()) {
                switch (aVar.ewU) {
                    case 0:
                        z3 = this.eob.mIsLogin;
                        if (z3) {
                            dhVar6 = this.eob.emx;
                            if (dhVar6.ic(false)) {
                                exVar6 = this.eob.enh;
                                exVar6.aPq();
                                return;
                            }
                            exVar5 = this.eob.enh;
                            dhVar7 = this.eob.emx;
                            exVar5.m(dhVar7.getPbData());
                            return;
                        }
                        return;
                    case 1:
                        z2 = this.eob.mIsLoading;
                        if (!z2) {
                            this.eob.mIsLoading = true;
                            exVar2 = this.eob.enh;
                            exVar2.erX.evd.setEnabled(false);
                            exVar3 = this.eob.enh;
                            exVar3.aud();
                            this.eob.aaO();
                            exVar4 = this.eob.enh;
                            exVar4.aPp();
                            dhVar5 = this.eob.emx;
                            aMX = this.eob.aMX();
                            dhVar5.oU(aMX);
                            return;
                        }
                        return;
                    case 2:
                        z = this.eob.emR;
                        if (z) {
                            dhVar2 = this.eob.emx;
                            boolean hostMode = dhVar2.getHostMode();
                            dhVar3 = this.eob.emx;
                            boolean aNO = dhVar3.aNO();
                            dhVar4 = this.eob.emx;
                            String threadID = dhVar4.getThreadID();
                            String str = aVar.postId;
                            int i2 = aVar.ewV;
                            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.eob.getPageContext().getPageActivity());
                            pbActivityConfig.createReaderServiceCfg(threadID, str, i2, hostMode, aNO, null);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                            this.eob.enn = false;
                            this.eob.finish();
                            return;
                        }
                        int i3 = aVar.ewV;
                        dhVar = this.eob.emx;
                        if (dhVar.getHostMode()) {
                            i = i3 + 3;
                        } else {
                            i = i3 + 2;
                        }
                        exVar = this.eob.enh;
                        exVar.Os().setSelection(i);
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
