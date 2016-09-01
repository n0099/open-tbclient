package com.baidu.tieba.pb.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.browser.f;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ BaobaoTailView exh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BaobaoTailView baobaoTailView) {
        this.exh = baobaoTailView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.data.b bVar;
        com.baidu.tbadk.data.b bVar2;
        com.baidu.tbadk.data.b bVar3;
        bVar = this.exh.exg;
        if (bVar != null) {
            bVar2 = this.exh.exg;
            if (bVar2.BP() != 1) {
                bVar3 = this.exh.exg;
                String BO = bVar3.BO();
                if (!j.isEmpty(BO)) {
                    f.u(this.exh.getContext(), BO);
                    return;
                }
                return;
            }
            try {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_LAUNCHBAOBAO, this.exh.getContext()));
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
