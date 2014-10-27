package com.baidu.tieba.mainentrance;

import android.app.AlertDialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity bmO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(SquareSearchActivity squareSearchActivity) {
        this.bmO = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new AlertDialog.Builder(this.bmO).setTitle(this.bmO.getString(com.baidu.tieba.y.alert_title)).setIcon(com.baidu.tieba.u.dialogue_quit).setMessage(this.bmO.getString(com.baidu.tieba.y.alert_clean_history)).setPositiveButton(this.bmO.getString(com.baidu.tieba.y.alert_yes_button), new u(this)).setNegativeButton(this.bmO.getString(com.baidu.tieba.y.alert_no_button), new w(this)).create().show();
    }
}
