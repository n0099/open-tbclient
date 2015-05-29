package com.baidu.tieba.pb.chosen;

import android.view.View;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class c extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PbChosenActivity bJa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PbChosenActivity pbChosenActivity, int i, int i2) {
        super(i, i2);
        this.bJa = pbChosenActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        View view;
        boolean z;
        View view2;
        if (responsedMessage instanceof com.baidu.tieba.pb.chosen.net.a) {
            com.baidu.tieba.pb.chosen.net.a aVar = (com.baidu.tieba.pb.chosen.net.a) responsedMessage;
            int erroCode = aVar.getErroCode();
            this.bJa.bIU = true;
            if (erroCode != 0 || aVar.isEmpty()) {
                PbChosenActivity pbChosenActivity = this.bJa;
                view = this.bJa.rootView;
                pbChosenActivity.hideLoadingView(view);
                this.bJa.showToast(StringUtils.isNull(aVar.getErrorText()) ? this.bJa.getResources().getString(t.neterror) : aVar.getErrorText());
            } else {
                this.bJa.a(aVar);
            }
            z = this.bJa.aIY;
            if (!z) {
                String string = this.bJa.getResources().getString(t.recommend_pb_no_net_text);
                PbChosenActivity pbChosenActivity2 = this.bJa;
                view2 = this.bJa.rootView;
                pbChosenActivity2.showNetRefreshView(view2, string, true);
            }
        }
    }
}
