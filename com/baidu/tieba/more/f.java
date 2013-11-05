package com.baidu.tieba.more;

import android.app.AlertDialog;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccountActivity f2007a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AccountActivity accountActivity) {
        this.f2007a = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new AlertDialog.Builder(this.f2007a).setTitle(R.string.alerm_title).setIcon((Drawable) null).setCancelable(true).setItems(R.array.delete_account, new g(this, view)).create().show();
    }
}
