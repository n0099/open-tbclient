package com.baidu.tieba.pb.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.browser.f;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ BaobaoTailView bOu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BaobaoTailView baobaoTailView) {
        this.bOu = baobaoTailView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.data.a aVar;
        com.baidu.tbadk.data.a aVar2;
        com.baidu.tbadk.data.a aVar3;
        aVar = this.bOu.bOt;
        if (aVar != null) {
            aVar2 = this.bOu.bOt;
            if (aVar2.xN() != 1) {
                aVar3 = this.bOu.bOt;
                String xM = aVar3.xM();
                if (!m.isEmpty(xM)) {
                    f.x(this.bOu.getContext(), xM);
                    return;
                }
                return;
            }
            try {
                MessageManager.getInstance().sendMessage(new CustomMessage(2802005, this.bOu.getContext()));
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
