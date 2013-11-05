package com.baidu.tieba.pb;

import android.widget.CompoundButton;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bt f2083a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(bt btVar) {
        this.f2083a = btVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            switch (compoundButton.getId()) {
                case R.id.radio_button_1day /* 2131100050 */:
                    this.f2083a.ae = 1;
                    return;
                case R.id.radio_button_3day /* 2131100051 */:
                    this.f2083a.ae = 3;
                    return;
                case R.id.radio_button_10day /* 2131100052 */:
                    this.f2083a.ae = 10;
                    return;
                default:
                    return;
            }
        }
    }
}
