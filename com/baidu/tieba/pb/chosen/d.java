package com.baidu.tieba.pb.chosen;

import android.widget.RelativeLayout;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class d extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PbChosenActivity cfM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(PbChosenActivity pbChosenActivity, int i, int i2) {
        super(i, i2);
        this.cfM = pbChosenActivity;
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
            this.cfM.cfC = true;
            if (erroCode != 0) {
                PbChosenActivity pbChosenActivity = this.cfM;
                relativeLayout = this.cfM.cfp;
                pbChosenActivity.hideLoadingView(relativeLayout);
                BdToast.b(this.cfM.getPageContext().getPageActivity(), StringUtils.isNull(aVar.getErrorText()) ? this.cfM.getResources().getString(i.h.neterror) : aVar.getErrorText()).sZ();
            } else {
                this.cfM.a(aVar);
            }
            z = this.cfM.aQd;
            if (!z) {
                String string = this.cfM.getResources().getString(i.h.error_unkown_try_again);
                PbChosenActivity pbChosenActivity2 = this.cfM;
                relativeLayout2 = this.cfM.cfp;
                pbChosenActivity2.showNetRefreshView(relativeLayout2, string, true);
                mVar = this.cfM.cft;
                mVar.setVisible(false);
            }
        }
    }
}
