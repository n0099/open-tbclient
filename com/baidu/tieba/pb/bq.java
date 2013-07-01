package com.baidu.tieba.pb;

import android.widget.CompoundButton;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bk f1235a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bk bkVar) {
        this.f1235a = bkVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            switch (compoundButton.getId()) {
                case R.id.radio_button_1day /* 2131099971 */:
                    this.f1235a.Y = 1;
                    return;
                case R.id.radio_button_3day /* 2131099972 */:
                    this.f1235a.Y = 3;
                    return;
                case R.id.radio_button_10day /* 2131099973 */:
                    this.f1235a.Y = 10;
                    return;
                default:
                    return;
            }
        }
    }
}
