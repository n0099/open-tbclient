package com.baidu.tieba.pb.main;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements View.OnClickListener {
    final /* synthetic */ az a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(az azVar) {
        this.a = azVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        Context context3;
        int intValue = ((Integer) ((bi) view.getTag()).F.getTag()).intValue();
        Object item = this.a.getItem(intValue);
        if (item instanceof com.baidu.tieba.data.ae) {
            com.baidu.tieba.data.ae aeVar = (com.baidu.tieba.data.ae) item;
            context = this.a.b;
            com.baidu.tbadk.core.f.a(context, "pb_tb_arc");
            new com.baidu.tbadk.core.util.az("", "pb_ck", aeVar.d()).start();
            int h = aeVar.h();
            if (h == 0) {
                context2 = this.a.b;
                AlertDialog.Builder title = new AlertDialog.Builder(context2).setTitle(com.baidu.tieba.y.del_post_tip);
                context3 = this.a.b;
                title.setMessage(context3.getString(com.baidu.tieba.y.pb_app_download_ask)).setPositiveButton(com.baidu.tieba.y.alert_yes_button, new bd(this, aeVar, intValue)).setNegativeButton(com.baidu.tieba.y.alert_no_button, (DialogInterface.OnClickListener) null).create().show();
            } else if (h == 2) {
                this.a.a(aeVar);
            }
        }
    }
}
