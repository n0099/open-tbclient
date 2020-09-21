package com.baidu.ufosdk.ui;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.ufosdk.R;
/* loaded from: classes21.dex */
final class ew implements View.OnFocusChangeListener {
    final /* synthetic */ RelativeLayout a;
    final /* synthetic */ ev b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ew(ev evVar, RelativeLayout relativeLayout) {
        this.b = evVar;
        this.a = relativeLayout;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        if (z) {
            this.a.setBackgroundResource(R.drawable.dialog_edit_bg_selected);
        } else {
            this.a.setBackgroundResource(R.drawable.dialog_checkbox_bg_normal);
        }
    }
}
