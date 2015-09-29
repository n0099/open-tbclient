package com.baidu.tieba.pb.chosen;

import android.widget.RelativeLayout;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class d extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PbChosenActivity cfa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(PbChosenActivity pbChosenActivity, int i, int i2) {
        super(i, i2);
        this.cfa = pbChosenActivity;
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
            this.cfa.ceQ = true;
            if (erroCode != 0) {
                PbChosenActivity pbChosenActivity = this.cfa;
                relativeLayout = this.cfa.ceD;
                pbChosenActivity.hideLoadingView(relativeLayout);
                BdToast.b(this.cfa.getPageContext().getPageActivity(), StringUtils.isNull(aVar.getErrorText()) ? this.cfa.getResources().getString(i.h.neterror) : aVar.getErrorText()).sZ();
            } else {
                this.cfa.a(aVar);
            }
            z = this.cfa.aPK;
            if (!z) {
                String string = this.cfa.getResources().getString(i.h.error_unkown_try_again);
                PbChosenActivity pbChosenActivity2 = this.cfa;
                relativeLayout2 = this.cfa.ceD;
                pbChosenActivity2.showNetRefreshView(relativeLayout2, string, true);
                mVar = this.cfa.ceH;
                mVar.setVisible(false);
            }
        }
    }
}
