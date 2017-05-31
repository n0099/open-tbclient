package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class aa extends CustomMessageListener {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(PbActivity pbActivity, int i) {
        super(i);
        this.enc = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        long j;
        if ((customResponsedMessage.getData() instanceof Integer) && this.enc.aJF() != null && this.enc.aJF().getPbData() != null && this.enc.aJF().getPbData().aIY() != null && this.enc.checkUpIsLogin() && !com.baidu.tieba.pb.e.M(this.enc.aJF().getPbData().aIB())) {
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            boolean aJe = this.enc.aJF().getPbData().aIY().aJe();
            if (intValue < 10) {
                if (!aJe) {
                    this.enc.f(this.enc.findViewById(w.h.view_main_thread_praise_state), intValue, false);
                }
                long currentTimeMillis = System.currentTimeMillis();
                j = this.enc.elK;
                if (currentTimeMillis - j > 2000) {
                    new com.baidu.tieba.pb.view.d(this.enc.getActivity()).startAnimation(false);
                    this.enc.elK = System.currentTimeMillis();
                    return;
                }
                return;
            }
            this.enc.f(this.enc.findViewById(w.h.view_main_thread_praise_state), intValue / 11, aJe);
        }
    }
}
