package com.baidu.tieba.pb.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.browser.f;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ BaobaoTailView bQJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BaobaoTailView baobaoTailView) {
        this.bQJ = baobaoTailView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.data.a aVar;
        com.baidu.tbadk.data.a aVar2;
        com.baidu.tbadk.data.a aVar3;
        aVar = this.bQJ.bQI;
        if (aVar != null) {
            aVar2 = this.bQJ.bQI;
            if (aVar2.yG() != 1) {
                aVar3 = this.bQJ.bQI;
                String yF = aVar3.yF();
                if (!m.isEmpty(yF)) {
                    f.x(this.bQJ.getContext(), yF);
                    return;
                }
                return;
            }
            try {
                MessageManager.getInstance().sendMessage(new CustomMessage(2802006, this.bQJ.getContext()));
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
