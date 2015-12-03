package com.baidu.tieba.pb.chosen;

import android.widget.RelativeLayout;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class d extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PbChosenActivity cyo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(PbChosenActivity pbChosenActivity, int i, int i2) {
        super(i, i2);
        this.cyo = pbChosenActivity;
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
            this.cyo.cyc = true;
            if (erroCode != 0) {
                PbChosenActivity pbChosenActivity = this.cyo;
                relativeLayout = this.cyo.cxP;
                pbChosenActivity.hideLoadingView(relativeLayout);
                this.cyo.showToast(StringUtils.isNull(aVar.getErrorText()) ? this.cyo.getResources().getString(n.i.neterror) : aVar.getErrorText());
            } else {
                this.cyo.a(aVar);
            }
            z = this.cyo.aVg;
            if (!z) {
                String string = this.cyo.getResources().getString(n.i.error_unkown_try_again);
                PbChosenActivity pbChosenActivity2 = this.cyo;
                relativeLayout2 = this.cyo.cxP;
                pbChosenActivity2.showNetRefreshView(relativeLayout2, string, true);
                lVar = this.cyo.cxT;
                lVar.setVisible(false);
            }
        }
    }
}
