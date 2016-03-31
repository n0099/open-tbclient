package com.baidu.tieba.pb.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ BaobaoTailView dqd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BaobaoTailView baobaoTailView) {
        this.dqd = baobaoTailView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.data.a aVar;
        com.baidu.tbadk.data.a aVar2;
        com.baidu.tbadk.data.a aVar3;
        aVar = this.dqd.dqc;
        if (aVar != null) {
            aVar2 = this.dqd.dqc;
            if (aVar2.CA() != 1) {
                aVar3 = this.dqd.dqc;
                String Cz = aVar3.Cz();
                if (!com.baidu.adp.lib.util.j.isEmpty(Cz)) {
                    com.baidu.tbadk.browser.f.s(this.dqd.getContext(), Cz);
                    return;
                }
                return;
            }
            try {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_LAUNCHBAOBAO, this.dqd.getContext()));
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
