package com.baidu.tieba.pb;

import android.widget.CompoundButton;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ bk a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bk bkVar) {
        this.a = bkVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            switch (compoundButton.getId()) {
                case R.id.radio_button_1day /* 2131099962 */:
                    this.a.Y = 1;
                    return;
                case R.id.radio_button_3day /* 2131099963 */:
                    this.a.Y = 3;
                    return;
                case R.id.radio_button_10day /* 2131099964 */:
                    this.a.Y = 10;
                    return;
                default:
                    return;
            }
        }
    }
}
