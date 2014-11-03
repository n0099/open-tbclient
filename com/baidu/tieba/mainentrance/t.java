package com.baidu.tieba.mainentrance;

import android.app.AlertDialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity bnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(SquareSearchActivity squareSearchActivity) {
        this.bnc = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new AlertDialog.Builder(this.bnc).setTitle(this.bnc.getString(com.baidu.tieba.y.alert_title)).setIcon(com.baidu.tieba.u.dialogue_quit).setMessage(this.bnc.getString(com.baidu.tieba.y.alert_clean_history)).setPositiveButton(this.bnc.getString(com.baidu.tieba.y.alert_yes_button), new u(this)).setNegativeButton(this.bnc.getString(com.baidu.tieba.y.alert_no_button), new w(this)).create().show();
    }
}
