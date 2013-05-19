package com.baidu.tieba.pb;

import android.widget.CompoundButton;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ bl a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bl blVar) {
        this.a = blVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            switch (compoundButton.getId()) {
                case R.id.radio_button_1day /* 2131099931 */:
                    this.a.Z = 1;
                    return;
                case R.id.radio_button_3day /* 2131099932 */:
                    this.a.Z = 3;
                    return;
                case R.id.radio_button_10day /* 2131099933 */:
                    this.a.Z = 10;
                    return;
                default:
                    return;
            }
        }
    }
}
