package com.baidu.tieba.pb.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ BaobaoTailView cVi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BaobaoTailView baobaoTailView) {
        this.cVi = baobaoTailView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.data.a aVar;
        com.baidu.tbadk.data.a aVar2;
        com.baidu.tbadk.data.a aVar3;
        aVar = this.cVi.cVh;
        if (aVar != null) {
            aVar2 = this.cVi.cVh;
            if (aVar2.BX() != 1) {
                aVar3 = this.cVi.cVh;
                String BW = aVar3.BW();
                if (!com.baidu.adp.lib.util.j.isEmpty(BW)) {
                    com.baidu.tbadk.browser.f.B(this.cVi.getContext(), BW);
                    return;
                }
                return;
            }
            try {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_LAUNCHBAOBAO, this.cVi.getContext()));
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
