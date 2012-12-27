package com.baidu.tieba.more;

import android.app.AlertDialog;
import android.view.View;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {
    final /* synthetic */ MsgRemindActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(MsgRemindActivity msgRemindActivity) {
        this.a = msgRemindActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        AlertDialog alertDialog3;
        AlertDialog alertDialog4;
        AlertDialog alertDialog5;
        AlertDialog alertDialog6;
        switch (view.getId()) {
            case R.id.remind_tone /* 2131231099 */:
                this.a.j = new AlertDialog.Builder(this.a).setTitle(R.string.remind_tone).setItems(R.array.menu_remind_tone, new ak(this)).create();
                alertDialog4 = this.a.j;
                alertDialog4.setOnCancelListener(new al(this));
                alertDialog5 = this.a.j;
                alertDialog5.setCanceledOnTouchOutside(true);
                alertDialog6 = this.a.j;
                alertDialog6.show();
                return;
            case R.id.text_remind_tone /* 2131231100 */:
            default:
                return;
            case R.id.remind_vibrate /* 2131231101 */:
                this.a.m = new AlertDialog.Builder(this.a).setTitle(R.string.remind_vibrate).setItems(R.array.menu_remind_tone, new am(this)).create();
                alertDialog = this.a.m;
                alertDialog.setOnCancelListener(new an(this));
                alertDialog2 = this.a.m;
                alertDialog2.setCanceledOnTouchOutside(true);
                alertDialog3 = this.a.m;
                alertDialog3.show();
                return;
        }
    }
}
