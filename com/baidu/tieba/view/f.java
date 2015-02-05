package com.baidu.tieba.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ BaobaoTailView ceG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaobaoTailView baobaoTailView) {
        this.ceG = baobaoTailView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.data.a aVar;
        com.baidu.tbadk.data.a aVar2;
        com.baidu.tbadk.data.a aVar3;
        aVar = this.ceG.ceF;
        if (aVar != null) {
            aVar2 = this.ceG.ceF;
            if (aVar2.uw() != 1) {
                aVar3 = this.ceG.ceF;
                String uv = aVar3.uv();
                if (!com.baidu.adp.lib.util.k.isEmpty(uv)) {
                    com.baidu.tbadk.browser.a.d(this.ceG.getContext(), uv, true);
                    return;
                }
                return;
            }
            try {
                MessageManager.getInstance().sendMessage(new CustomMessage(2802005, this.ceG.getContext()));
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
