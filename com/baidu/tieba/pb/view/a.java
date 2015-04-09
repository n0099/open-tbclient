package com.baidu.tieba.pb.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.browser.f;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ BaobaoTailView bOK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BaobaoTailView baobaoTailView) {
        this.bOK = baobaoTailView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.data.a aVar;
        com.baidu.tbadk.data.a aVar2;
        com.baidu.tbadk.data.a aVar3;
        aVar = this.bOK.bOJ;
        if (aVar != null) {
            aVar2 = this.bOK.bOJ;
            if (aVar2.xT() != 1) {
                aVar3 = this.bOK.bOJ;
                String xS = aVar3.xS();
                if (!m.isEmpty(xS)) {
                    f.x(this.bOK.getContext(), xS);
                    return;
                }
                return;
            }
            try {
                MessageManager.getInstance().sendMessage(new CustomMessage(2802005, this.bOK.getContext()));
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
