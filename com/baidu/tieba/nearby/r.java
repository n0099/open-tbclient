package com.baidu.tieba.nearby;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NearbyPbActivity f1175a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(NearbyPbActivity nearbyPbActivity) {
        this.f1175a = nearbyPbActivity;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Button button;
        Button button2;
        if (editable == null || editable.length() <= 0) {
            button = this.f1175a.c;
            button.setEnabled(false);
            return;
        }
        button2 = this.f1175a.c;
        button2.setEnabled(true);
    }
}
