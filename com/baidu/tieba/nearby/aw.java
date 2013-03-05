package com.baidu.tieba.nearby;

import android.widget.RadioGroup;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements android.support.v4.view.aj {
    final /* synthetic */ NewNearbyActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(NewNearbyActivity newNearbyActivity) {
        this.a = newNearbyActivity;
    }

    @Override // android.support.v4.view.aj
    public void a(int i) {
        boolean z;
        RadioGroup radioGroup;
        RadioGroup radioGroup2;
        RadioGroup radioGroup3;
        RadioGroup radioGroup4;
        com.baidu.tieba.c.ag.c("onPageSelected positon = " + String.valueOf(i));
        z = this.a.x;
        if (!z) {
            this.a.y = true;
            if (i == 0) {
                radioGroup3 = this.a.p;
                if (radioGroup3.getCheckedRadioButtonId() != R.id.title_lbs_threads) {
                    radioGroup4 = this.a.p;
                    radioGroup4.check(R.id.title_lbs_threads);
                }
            } else {
                radioGroup = this.a.p;
                if (radioGroup.getCheckedRadioButtonId() != R.id.title_lbs_bars) {
                    radioGroup2 = this.a.p;
                    radioGroup2.check(R.id.title_lbs_bars);
                }
            }
            this.a.y = false;
        }
    }

    @Override // android.support.v4.view.aj
    public void a(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.aj
    public void b(int i) {
    }
}
