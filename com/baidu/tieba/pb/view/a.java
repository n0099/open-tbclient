package com.baidu.tieba.pb.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.browser.g;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ BaobaoTailView cpf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BaobaoTailView baobaoTailView) {
        this.cpf = baobaoTailView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.data.a aVar;
        com.baidu.tbadk.data.a aVar2;
        com.baidu.tbadk.data.a aVar3;
        aVar = this.cpf.cpe;
        if (aVar != null) {
            aVar2 = this.cpf.cpe;
            if (aVar2.zV() != 1) {
                aVar3 = this.cpf.cpe;
                String zU = aVar3.zU();
                if (!j.isEmpty(zU)) {
                    g.B(this.cpf.getContext(), zU);
                    return;
                }
                return;
            }
            try {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_LAUNCHBAOBAO, this.cpf.getContext()));
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
