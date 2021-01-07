package com.baidu.ufosdk.ui;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.ufosdk.R;
/* loaded from: classes8.dex */
final class ew implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RelativeLayout f5863a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ev f5864b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ew(ev evVar, RelativeLayout relativeLayout) {
        this.f5864b = evVar;
        this.f5863a = relativeLayout;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        if (z) {
            this.f5863a.setBackgroundResource(R.drawable.dialog_edit_bg_selected);
        } else {
            this.f5863a.setBackgroundResource(R.drawable.dialog_checkbox_bg_normal);
        }
    }
}
