package com.baidu.tieba.pb.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ BaobaoTailView drM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BaobaoTailView baobaoTailView) {
        this.drM = baobaoTailView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.data.b bVar;
        com.baidu.tbadk.data.b bVar2;
        com.baidu.tbadk.data.b bVar3;
        bVar = this.drM.drL;
        if (bVar != null) {
            bVar2 = this.drM.drL;
            if (bVar2.Au() != 1) {
                bVar3 = this.drM.drL;
                String At = bVar3.At();
                if (!com.baidu.adp.lib.util.j.isEmpty(At)) {
                    com.baidu.tbadk.browser.f.t(this.drM.getContext(), At);
                    return;
                }
                return;
            }
            try {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_LAUNCHBAOBAO, this.drM.getContext()));
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
