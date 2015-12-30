package com.baidu.tieba.pb.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ BaobaoTailView cMu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BaobaoTailView baobaoTailView) {
        this.cMu = baobaoTailView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.data.a aVar;
        com.baidu.tbadk.data.a aVar2;
        com.baidu.tbadk.data.a aVar3;
        aVar = this.cMu.cMt;
        if (aVar != null) {
            aVar2 = this.cMu.cMt;
            if (aVar2.AH() != 1) {
                aVar3 = this.cMu.cMt;
                String AG = aVar3.AG();
                if (!com.baidu.adp.lib.util.j.isEmpty(AG)) {
                    com.baidu.tbadk.browser.f.B(this.cMu.getContext(), AG);
                    return;
                }
                return;
            }
            try {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_LAUNCHBAOBAO, this.cMu.getContext()));
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
