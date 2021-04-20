package com.baidu.ufosdk.ui;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.ufosdk.R;
/* loaded from: classes5.dex */
public final class ew implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RelativeLayout f22935a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ev f22936b;

    public ew(ev evVar, RelativeLayout relativeLayout) {
        this.f22936b = evVar;
        this.f22935a = relativeLayout;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        this.f22935a.setBackgroundResource(z ? R.drawable.dialog_edit_bg_selected : R.drawable.dialog_checkbox_bg_normal);
    }
}
