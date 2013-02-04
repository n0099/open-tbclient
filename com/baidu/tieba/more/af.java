package com.baidu.tieba.more;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.view.View;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    final /* synthetic */ MoreActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(MoreActivity moreActivity) {
        this.a = moreActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        Dialog dialog3;
        try {
            try {
                Intent intent = new Intent("/");
                intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.DisplaySettings"));
                intent.setAction("android.intent.action.VIEW");
                this.a.startActivityForResult(intent, 0);
                dialog3 = this.a.z;
                dialog3.dismiss();
            } catch (Exception e) {
                this.a.b(this.a.getString(R.string.goto_setting_tip));
                dialog = this.a.z;
                dialog.dismiss();
            }
        } catch (Throwable th) {
            dialog2 = this.a.z;
            dialog2.dismiss();
            throw th;
        }
    }
}
