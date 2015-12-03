package com.baidu.tieba.pb.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ BaobaoTailView cIr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BaobaoTailView baobaoTailView) {
        this.cIr = baobaoTailView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.data.a aVar;
        com.baidu.tbadk.data.a aVar2;
        com.baidu.tbadk.data.a aVar3;
        aVar = this.cIr.cIq;
        if (aVar != null) {
            aVar2 = this.cIr.cIq;
            if (aVar2.AR() != 1) {
                aVar3 = this.cIr.cIq;
                String AQ = aVar3.AQ();
                if (!j.isEmpty(AQ)) {
                    com.baidu.tbadk.browser.f.B(this.cIr.getContext(), AQ);
                    return;
                }
                return;
            }
            try {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_LAUNCHBAOBAO, this.cIr.getContext()));
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
