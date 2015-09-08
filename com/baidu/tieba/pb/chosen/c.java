package com.baidu.tieba.pb.chosen;

import android.widget.RelativeLayout;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class c extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PbChosenActivity bZS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PbChosenActivity pbChosenActivity, int i, int i2) {
        super(i, i2);
        this.bZS = pbChosenActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        RelativeLayout relativeLayout;
        boolean z;
        RelativeLayout relativeLayout2;
        com.baidu.tieba.pb.chosen.a.m mVar;
        if (responsedMessage instanceof com.baidu.tieba.pb.chosen.net.a) {
            com.baidu.tieba.pb.chosen.net.a aVar = (com.baidu.tieba.pb.chosen.net.a) responsedMessage;
            int erroCode = aVar.getErroCode();
            this.bZS.bZI = true;
            if (erroCode != 0) {
                PbChosenActivity pbChosenActivity = this.bZS;
                relativeLayout = this.bZS.bZv;
                pbChosenActivity.hideLoadingView(relativeLayout);
                BdToast.b(this.bZS.getPageContext().getPageActivity(), StringUtils.isNull(aVar.getErrorText()) ? this.bZS.getResources().getString(i.h.neterror) : aVar.getErrorText()).tc();
            } else {
                this.bZS.a(aVar);
            }
            z = this.bZS.aQO;
            if (!z) {
                String string = this.bZS.getResources().getString(i.h.error_unkown_try_again);
                PbChosenActivity pbChosenActivity2 = this.bZS;
                relativeLayout2 = this.bZS.bZv;
                pbChosenActivity2.showNetRefreshView(relativeLayout2, string, true);
                mVar = this.bZS.bZz;
                mVar.setVisible(false);
            }
        }
    }
}
