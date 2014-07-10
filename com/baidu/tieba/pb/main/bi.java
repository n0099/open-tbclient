package com.baidu.tieba.pb.main;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements View.OnClickListener {
    final /* synthetic */ bc a;
    private final /* synthetic */ com.baidu.tieba.data.ah b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(bc bcVar, com.baidu.tieba.data.ah ahVar) {
        this.a = bcVar;
        this.b = ahVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        String f = this.b.f();
        if (!com.baidu.tbadk.core.util.bm.c(f)) {
            context = this.a.b;
            AlertDialog.Builder title = new AlertDialog.Builder(context).setTitle(com.baidu.tieba.y.del_post_tip);
            context2 = this.a.b;
            title.setMessage(context2.getString(com.baidu.tieba.y.pb_app_see_ask)).setPositiveButton(com.baidu.tieba.y.alert_yes_button, new bj(this, this.b, f)).setNegativeButton(com.baidu.tieba.y.alert_no_button, (DialogInterface.OnClickListener) null).create().show();
        }
    }
}
