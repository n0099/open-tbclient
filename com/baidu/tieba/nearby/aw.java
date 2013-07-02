package com.baidu.tieba.nearby;

import android.support.v4.view.bq;
import android.widget.RadioGroup;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements bq {
    final /* synthetic */ NewNearbyActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(NewNearbyActivity newNearbyActivity) {
        this.a = newNearbyActivity;
    }

    @Override // android.support.v4.view.bq
    public void a_(int i) {
        boolean z;
        RadioGroup radioGroup;
        RadioGroup radioGroup2;
        RadioGroup radioGroup3;
        RadioGroup radioGroup4;
        com.baidu.tieba.util.z.c("onPageSelected positon = " + String.valueOf(i));
        z = this.a.B;
        if (!z) {
            this.a.C = true;
            if (i == 0) {
                radioGroup3 = this.a.t;
                if (radioGroup3.getCheckedRadioButtonId() != R.id.title_lbs_threads) {
                    radioGroup4 = this.a.t;
                    radioGroup4.check(R.id.title_lbs_threads);
                }
            } else {
                radioGroup = this.a.t;
                if (radioGroup.getCheckedRadioButtonId() != R.id.title_lbs_bars) {
                    radioGroup2 = this.a.t;
                    radioGroup2.check(R.id.title_lbs_bars);
                }
            }
            this.a.C = false;
        }
    }

    @Override // android.support.v4.view.bq
    public void a(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.bq
    public void b(int i) {
    }
}
