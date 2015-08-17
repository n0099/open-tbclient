package com.baidu.tieba.pb.chosen;

import android.widget.RelativeLayout;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class c extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PbChosenActivity bYY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PbChosenActivity pbChosenActivity, int i, int i2) {
        super(i, i2);
        this.bYY = pbChosenActivity;
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
            this.bYY.bYO = true;
            if (erroCode != 0) {
                PbChosenActivity pbChosenActivity = this.bYY;
                relativeLayout = this.bYY.bYB;
                pbChosenActivity.hideLoadingView(relativeLayout);
                BdToast.b(this.bYY.getPageContext().getPageActivity(), StringUtils.isNull(aVar.getErrorText()) ? this.bYY.getResources().getString(i.C0057i.neterror) : aVar.getErrorText()).sX();
            } else {
                this.bYY.a(aVar);
            }
            z = this.bYY.aQA;
            if (!z) {
                String string = this.bYY.getResources().getString(i.C0057i.error_unkown_try_again);
                PbChosenActivity pbChosenActivity2 = this.bYY;
                relativeLayout2 = this.bYY.bYB;
                pbChosenActivity2.showNetRefreshView(relativeLayout2, string, true);
                mVar = this.bYY.bYF;
                mVar.setVisible(false);
            }
        }
    }
}
