package com.baidu.tieba.pb;

import android.widget.CompoundButton;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ br f1571a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(br brVar) {
        this.f1571a = brVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            switch (compoundButton.getId()) {
                case R.id.radio_button_1day /* 2131100011 */:
                    this.f1571a.ae = 1;
                    return;
                case R.id.radio_button_3day /* 2131100012 */:
                    this.f1571a.ae = 3;
                    return;
                case R.id.radio_button_10day /* 2131100013 */:
                    this.f1571a.ae = 10;
                    return;
                default:
                    return;
            }
        }
    }
}
