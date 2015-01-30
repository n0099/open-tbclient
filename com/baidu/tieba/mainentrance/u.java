package com.baidu.tieba.mainentrance;

import android.app.AlertDialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity btb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(SquareSearchActivity squareSearchActivity) {
        this.btb = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new AlertDialog.Builder(this.btb.getPageContext().getPageActivity()).setTitle(this.btb.getPageContext().getString(com.baidu.tieba.z.alert_title)).setIcon(com.baidu.tieba.v.dialogue_quit).setMessage(this.btb.getPageContext().getString(com.baidu.tieba.z.alert_clean_history)).setPositiveButton(this.btb.getPageContext().getString(com.baidu.tieba.z.alert_yes_button), new v(this)).setNegativeButton(this.btb.getPageContext().getString(com.baidu.tieba.z.alert_no_button), new x(this)).create().show();
    }
}
