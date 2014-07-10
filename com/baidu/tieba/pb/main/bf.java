package com.baidu.tieba.pb.main;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements View.OnClickListener {
    final /* synthetic */ bc a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(bc bcVar) {
        this.a = bcVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        Context context3;
        int intValue = ((Integer) ((bl) view.getTag()).G.getTag()).intValue();
        Object item = this.a.getItem(intValue);
        if (item instanceof com.baidu.tieba.data.ah) {
            com.baidu.tieba.data.ah ahVar = (com.baidu.tieba.data.ah) item;
            context = this.a.b;
            TiebaStatic.eventStat(context, "pb_ck_app", null, 1, "app_name", ahVar.d());
            int h = ahVar.h();
            if (h == 0) {
                context2 = this.a.b;
                AlertDialog.Builder title = new AlertDialog.Builder(context2).setTitle(com.baidu.tieba.y.del_post_tip);
                context3 = this.a.b;
                title.setMessage(context3.getString(com.baidu.tieba.y.pb_app_download_ask)).setPositiveButton(com.baidu.tieba.y.alert_yes_button, new bg(this, ahVar, intValue)).setNegativeButton(com.baidu.tieba.y.alert_no_button, (DialogInterface.OnClickListener) null).create().show();
            } else if (h == 2) {
                this.a.a(ahVar);
            }
        }
    }
}
