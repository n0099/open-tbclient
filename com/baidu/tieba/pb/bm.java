package com.baidu.tieba.pb;

import android.text.ClipboardManager;
import android.view.View;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2097a;
    final /* synthetic */ NewPbActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(NewPbActivity newPbActivity, String str) {
        this.b = newPbActivity;
        this.f2097a = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ((ClipboardManager) view.getContext().getSystemService("clipboard")).setText(this.f2097a);
        UtilHelper.a(view.getContext(), view.getResources().getString(R.string.copy_pb_url_success));
    }
}
