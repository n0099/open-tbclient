package com.baidu.tieba.pb;

import android.widget.CompoundButton;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cy implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ SubPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(SubPbActivity subPbActivity) {
        this.a = subPbActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            switch (compoundButton.getId()) {
                case R.id.radio_button_1day /* 2131230959 */:
                    this.a.U = 1;
                    return;
                case R.id.radio_button_3day /* 2131230960 */:
                    this.a.U = 3;
                    return;
                case R.id.radio_button_10day /* 2131230961 */:
                    this.a.U = 10;
                    return;
                default:
                    return;
            }
        }
    }
}
