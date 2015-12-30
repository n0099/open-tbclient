package com.baidu.tieba.pb.chosen;

import android.widget.RelativeLayout;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class d extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PbChosenActivity cBV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(PbChosenActivity pbChosenActivity, int i, int i2) {
        super(i, i2);
        this.cBV = pbChosenActivity;
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
            this.cBV.cBJ = true;
            if (erroCode != 0) {
                PbChosenActivity pbChosenActivity = this.cBV;
                relativeLayout = this.cBV.cBw;
                pbChosenActivity.hideLoadingView(relativeLayout);
                this.cBV.showToast(StringUtils.isNull(aVar.getErrorText()) ? this.cBV.getResources().getString(n.j.neterror) : aVar.getErrorText());
            } else {
                this.cBV.a(aVar);
            }
            z = this.cBV.aZg;
            if (!z) {
                String string = this.cBV.getResources().getString(n.j.error_unkown_try_again);
                PbChosenActivity pbChosenActivity2 = this.cBV;
                relativeLayout2 = this.cBV.cBw;
                pbChosenActivity2.showNetRefreshView(relativeLayout2, string, true);
                lVar = this.cBV.cBA;
                lVar.setVisible(false);
            }
        }
    }
}
