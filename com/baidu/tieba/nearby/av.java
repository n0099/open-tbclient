package com.baidu.tieba.nearby;

import android.widget.RadioGroup;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements android.support.v4.view.aj {
    final /* synthetic */ NewNearbyActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(NewNearbyActivity newNearbyActivity) {
        this.a = newNearbyActivity;
    }

    @Override // android.support.v4.view.aj
    public void a(int i) {
        boolean z;
        RadioGroup radioGroup;
        RadioGroup radioGroup2;
        RadioGroup radioGroup3;
        RadioGroup radioGroup4;
        com.baidu.tieba.d.ae.c("onPageSelected positon = " + String.valueOf(i));
        z = this.a.y;
        if (!z) {
            this.a.z = true;
            if (i == 0) {
                radioGroup3 = this.a.q;
                if (radioGroup3.getCheckedRadioButtonId() != R.id.title_lbs_threads) {
                    radioGroup4 = this.a.q;
                    radioGroup4.check(R.id.title_lbs_threads);
                }
            } else {
                radioGroup = this.a.q;
                if (radioGroup.getCheckedRadioButtonId() != R.id.title_lbs_bars) {
                    radioGroup2 = this.a.q;
                    radioGroup2.check(R.id.title_lbs_bars);
                }
            }
            this.a.z = false;
        }
    }

    @Override // android.support.v4.view.aj
    public void a(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.aj
    public void b(int i) {
    }
}
