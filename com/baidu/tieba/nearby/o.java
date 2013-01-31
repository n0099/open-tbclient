package com.baidu.tieba.nearby;

import android.widget.CompoundButton;
import android.widget.RadioButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ NearbyActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(NearbyActivity nearbyActivity) {
        this.a = nearbyActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        RadioButton radioButton;
        RadioButton radioButton2;
        if (z) {
            radioButton = this.a.e;
            if (compoundButton != radioButton) {
                radioButton2 = this.a.f;
                if (compoundButton == radioButton2) {
                    this.a.a("list", NearbyListActivity.class);
                    return;
                }
                return;
            }
            this.a.a("radar", LbsActivity.class);
        }
    }
}
