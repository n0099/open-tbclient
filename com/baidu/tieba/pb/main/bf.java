package com.baidu.tieba.pb.main;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements View.OnClickListener {
    final /* synthetic */ az a;
    private final /* synthetic */ com.baidu.tieba.data.ae b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(az azVar, com.baidu.tieba.data.ae aeVar) {
        this.a = azVar;
        this.b = aeVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        String f = this.b.f();
        if (!com.baidu.tbadk.core.util.bg.c(f)) {
            context = this.a.b;
            AlertDialog.Builder title = new AlertDialog.Builder(context).setTitle(com.baidu.tieba.y.del_post_tip);
            context2 = this.a.b;
            title.setMessage(context2.getString(com.baidu.tieba.y.pb_app_see_ask)).setPositiveButton(com.baidu.tieba.y.alert_yes_button, new bg(this, this.b, f)).setNegativeButton(com.baidu.tieba.y.alert_no_button, (DialogInterface.OnClickListener) null).create().show();
        }
    }
}
