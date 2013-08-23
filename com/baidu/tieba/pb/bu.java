package com.baidu.tieba.pb;

import android.widget.CompoundButton;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bo f1524a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(bo boVar) {
        this.f1524a = boVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            switch (compoundButton.getId()) {
                case R.id.radio_button_1day /* 2131100013 */:
                    this.f1524a.aa = 1;
                    return;
                case R.id.radio_button_3day /* 2131100014 */:
                    this.f1524a.aa = 3;
                    return;
                case R.id.radio_button_10day /* 2131100015 */:
                    this.f1524a.aa = 10;
                    return;
                default:
                    return;
            }
        }
    }
}
