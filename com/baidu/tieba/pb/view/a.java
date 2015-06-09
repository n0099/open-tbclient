package com.baidu.tieba.pb.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.browser.f;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ BaobaoTailView bQK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BaobaoTailView baobaoTailView) {
        this.bQK = baobaoTailView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.data.a aVar;
        com.baidu.tbadk.data.a aVar2;
        com.baidu.tbadk.data.a aVar3;
        aVar = this.bQK.bQJ;
        if (aVar != null) {
            aVar2 = this.bQK.bQJ;
            if (aVar2.yH() != 1) {
                aVar3 = this.bQK.bQJ;
                String yG = aVar3.yG();
                if (!m.isEmpty(yG)) {
                    f.x(this.bQK.getContext(), yG);
                    return;
                }
                return;
            }
            try {
                MessageManager.getInstance().sendMessage(new CustomMessage(2802006, this.bQK.getContext()));
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
