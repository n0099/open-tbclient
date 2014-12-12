package com.baidu.tieba.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ BaobaoTailView cdi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BaobaoTailView baobaoTailView) {
        this.cdi = baobaoTailView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.data.a aVar;
        com.baidu.tbadk.data.a aVar2;
        com.baidu.tbadk.data.a aVar3;
        aVar = this.cdi.cdh;
        if (aVar != null) {
            aVar2 = this.cdi.cdh;
            if (aVar2.ul() != 1) {
                aVar3 = this.cdi.cdh;
                String uk = aVar3.uk();
                if (!com.baidu.adp.lib.util.k.isEmpty(uk)) {
                    com.baidu.tbadk.browser.a.c(this.cdi.getContext(), uk, true);
                    return;
                }
                return;
            }
            try {
                MessageManager.getInstance().sendMessage(new CustomMessage(2802005, this.cdi.getContext()));
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
