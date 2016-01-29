package com.baidu.tieba.pb.chosen;

import android.widget.RelativeLayout;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class d extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PbChosenActivity cIA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(PbChosenActivity pbChosenActivity, int i, int i2) {
        super(i, i2);
        this.cIA = pbChosenActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        RelativeLayout relativeLayout;
        boolean z;
        RelativeLayout relativeLayout2;
        com.baidu.tieba.pb.chosen.a.l lVar;
        if (responsedMessage instanceof com.baidu.tieba.pb.chosen.net.a) {
            com.baidu.tieba.pb.chosen.net.a aVar = (com.baidu.tieba.pb.chosen.net.a) responsedMessage;
            int erroCode = aVar.getErroCode();
            this.cIA.cIp = true;
            if (erroCode != 0) {
                PbChosenActivity pbChosenActivity = this.cIA;
                relativeLayout = this.cIA.cIc;
                pbChosenActivity.hideLoadingView(relativeLayout);
                this.cIA.showToast(StringUtils.isNull(aVar.getErrorText()) ? this.cIA.getResources().getString(t.j.neterror) : aVar.getErrorText());
            } else {
                this.cIA.a(aVar);
            }
            z = this.cIA.bbv;
            if (!z) {
                String string = this.cIA.getResources().getString(t.j.error_unkown_try_again);
                PbChosenActivity pbChosenActivity2 = this.cIA;
                relativeLayout2 = this.cIA.cIc;
                pbChosenActivity2.showNetRefreshView(relativeLayout2, string, true);
                lVar = this.cIA.cIg;
                lVar.setVisible(false);
            }
        }
    }
}
