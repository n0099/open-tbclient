package com.baidu.tieba.pb;

import android.widget.CompoundButton;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            switch (compoundButton.getId()) {
                case R.id.radio_button_1day /* 2131230968 */:
                    this.a.L = 1;
                    return;
                case R.id.radio_button_3day /* 2131230969 */:
                    this.a.L = 3;
                    return;
                case R.id.radio_button_10day /* 2131230970 */:
                    this.a.L = 10;
                    return;
                default:
                    return;
            }
        }
    }
}
