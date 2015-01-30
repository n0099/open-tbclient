package com.baidu.tieba.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ BaobaoTailView ceH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaobaoTailView baobaoTailView) {
        this.ceH = baobaoTailView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.data.a aVar;
        com.baidu.tbadk.data.a aVar2;
        com.baidu.tbadk.data.a aVar3;
        aVar = this.ceH.ceG;
        if (aVar != null) {
            aVar2 = this.ceH.ceG;
            if (aVar2.uC() != 1) {
                aVar3 = this.ceH.ceG;
                String uB = aVar3.uB();
                if (!com.baidu.adp.lib.util.k.isEmpty(uB)) {
                    com.baidu.tbadk.browser.a.d(this.ceH.getContext(), uB, true);
                    return;
                }
                return;
            }
            try {
                MessageManager.getInstance().sendMessage(new CustomMessage(2802005, this.ceH.getContext()));
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
