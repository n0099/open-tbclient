package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class ab extends CustomMessageListener {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(PbActivity pbActivity, int i) {
        super(i);
        this.ewh = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        gg ggVar;
        long j;
        ggVar = this.ewh.euU;
        if (ggVar.aQf() && (customResponsedMessage.getData() instanceof Integer) && this.ewh.aNz() != null && this.ewh.aNz().getPbData() != null && this.ewh.aNz().getPbData().aMS() != null && this.ewh.checkUpIsLogin() && !com.baidu.tieba.pb.i.N(this.ewh.aNz().getPbData().aMv())) {
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            boolean aMY = this.ewh.aNz().getPbData().aMS().aMY();
            if (intValue < 10) {
                if (!aMY) {
                    this.ewh.f(this.ewh.findViewById(w.h.view_main_thread_praise_state), intValue, false);
                    TiebaStatic.log(this.ewh.aNC().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aMY ? 0 : 1));
                }
                long currentTimeMillis = System.currentTimeMillis();
                j = this.ewh.euK;
                if (currentTimeMillis - j > 2000) {
                    new com.baidu.tieba.pb.view.d(this.ewh.getActivity()).startAnimation(false);
                    this.ewh.euK = System.currentTimeMillis();
                    return;
                }
                return;
            }
            this.ewh.f(this.ewh.findViewById(w.h.view_main_thread_praise_state), intValue / 11, aMY);
            TiebaStatic.log(this.ewh.aNC().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 3).r("obj_locate", 4).r("obj_id", aMY ? 0 : 1));
        }
    }
}
