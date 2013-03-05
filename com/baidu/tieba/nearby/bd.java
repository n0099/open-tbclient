package com.baidu.tieba.nearby;

import android.support.v4.view.ViewPager;
import android.widget.CompoundButton;
import android.widget.RadioButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ NewNearbyActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(NewNearbyActivity newNearbyActivity) {
        this.a = newNearbyActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        boolean z2;
        ViewPager viewPager;
        ViewPager viewPager2;
        RadioButton radioButton;
        ViewPager viewPager3;
        ViewPager viewPager4;
        ViewPager viewPager5;
        ViewPager viewPager6;
        if (z) {
            com.baidu.tieba.c.ag.c("onCheckedChanged id = " + String.valueOf(compoundButton.getId()));
            z2 = this.a.y;
            if (!z2) {
                viewPager = this.a.j;
                if (viewPager != null) {
                    viewPager2 = this.a.j;
                    if (viewPager2.getChildCount() >= 2) {
                        this.a.x = true;
                        radioButton = this.a.r;
                        if (compoundButton == radioButton) {
                            viewPager5 = this.a.j;
                            if (viewPager5.getCurrentItem() != 0) {
                                viewPager6 = this.a.j;
                                viewPager6.a(0, true);
                            }
                        } else {
                            viewPager3 = this.a.j;
                            if (viewPager3.getCurrentItem() != 1) {
                                viewPager4 = this.a.j;
                                viewPager4.a(1, true);
                            }
                        }
                        this.a.x = false;
                    }
                }
            }
        }
    }
}
