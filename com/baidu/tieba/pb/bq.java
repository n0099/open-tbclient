package com.baidu.tieba.pb;

import android.text.ClipboardManager;
import android.view.View;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements View.OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ NewPbActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(NewPbActivity newPbActivity, String str) {
        this.b = newPbActivity;
        this.a = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ((ClipboardManager) view.getContext().getSystemService("clipboard")).setText(this.a);
        com.baidu.adp.lib.h.g.a(view.getContext(), view.getResources().getString(R.string.copy_pb_url_success));
    }
}
