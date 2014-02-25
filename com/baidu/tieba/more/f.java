package com.baidu.tieba.more;

import android.app.AlertDialog;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ AccountActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AccountActivity accountActivity) {
        this.a = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new AlertDialog.Builder(this.a).setTitle(R.string.alerm_title).setIcon((Drawable) null).setCancelable(true).setItems(R.array.delete_account, new g(this, view)).create().show();
    }
}
