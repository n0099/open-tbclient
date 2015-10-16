package com.baidu.tieba.pb.chosen;

import android.widget.RelativeLayout;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class d extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PbChosenActivity cfl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(PbChosenActivity pbChosenActivity, int i, int i2) {
        super(i, i2);
        this.cfl = pbChosenActivity;
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
            this.cfl.cfb = true;
            if (erroCode != 0) {
                PbChosenActivity pbChosenActivity = this.cfl;
                relativeLayout = this.cfl.ceO;
                pbChosenActivity.hideLoadingView(relativeLayout);
                BdToast.b(this.cfl.getPageContext().getPageActivity(), StringUtils.isNull(aVar.getErrorText()) ? this.cfl.getResources().getString(i.h.neterror) : aVar.getErrorText()).sZ();
            } else {
                this.cfl.a(aVar);
            }
            z = this.cfl.aPV;
            if (!z) {
                String string = this.cfl.getResources().getString(i.h.error_unkown_try_again);
                PbChosenActivity pbChosenActivity2 = this.cfl;
                relativeLayout2 = this.cfl.ceO;
                pbChosenActivity2.showNetRefreshView(relativeLayout2, string, true);
                mVar = this.cfl.ceS;
                mVar.setVisible(false);
            }
        }
    }
}
