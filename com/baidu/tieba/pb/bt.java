package com.baidu.tieba.pb;

import android.widget.CompoundButton;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bn f1488a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bn bnVar) {
        this.f1488a = bnVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            switch (compoundButton.getId()) {
                case R.id.radio_button_1day /* 2131099997 */:
                    this.f1488a.Y = 1;
                    return;
                case R.id.radio_button_3day /* 2131099998 */:
                    this.f1488a.Y = 3;
                    return;
                case R.id.radio_button_10day /* 2131099999 */:
                    this.f1488a.Y = 10;
                    return;
                default:
                    return;
            }
        }
    }
}
