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
    final /* synthetic */ BaobaoTailView ekZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BaobaoTailView baobaoTailView) {
        this.ekZ = baobaoTailView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.data.b bVar;
        com.baidu.tbadk.data.b bVar2;
        com.baidu.tbadk.data.b bVar3;
        bVar = this.ekZ.ekY;
        if (bVar != null) {
            bVar2 = this.ekZ.ekY;
            if (bVar2.AA() != 1) {
                bVar3 = this.ekZ.ekY;
                String Az = bVar3.Az();
                if (!j.isEmpty(Az)) {
                    f.u(this.ekZ.getContext(), Az);
                    return;
                }
                return;
            }
            try {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_LAUNCHBAOBAO, this.ekZ.getContext()));
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
