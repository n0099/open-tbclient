package com.baidu.tieba.nearby;

import android.support.v4.view.bq;
import android.widget.RadioGroup;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements bq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewNearbyActivity f1145a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(NewNearbyActivity newNearbyActivity) {
        this.f1145a = newNearbyActivity;
    }

    @Override // android.support.v4.view.bq
    public void a_(int i) {
        boolean z;
        RadioGroup radioGroup;
        RadioGroup radioGroup2;
        RadioGroup radioGroup3;
        RadioGroup radioGroup4;
        com.baidu.tieba.util.z.c("onPageSelected positon = " + String.valueOf(i));
        z = this.f1145a.B;
        if (!z) {
            this.f1145a.C = true;
            if (i == 0) {
                radioGroup3 = this.f1145a.t;
                if (radioGroup3.getCheckedRadioButtonId() != R.id.title_lbs_threads) {
                    radioGroup4 = this.f1145a.t;
                    radioGroup4.check(R.id.title_lbs_threads);
                }
            } else {
                radioGroup = this.f1145a.t;
                if (radioGroup.getCheckedRadioButtonId() != R.id.title_lbs_bars) {
                    radioGroup2 = this.f1145a.t;
                    radioGroup2.check(R.id.title_lbs_bars);
                }
            }
            this.f1145a.C = false;
        }
    }

    @Override // android.support.v4.view.bq
    public void a(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.bq
    public void b(int i) {
    }
}
