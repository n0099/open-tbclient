package com.baidu.tieba.nearby;

import android.support.v4.view.ViewPager;
import android.widget.CompoundButton;
import android.widget.RadioButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewNearbyActivity f1156a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(NewNearbyActivity newNearbyActivity) {
        this.f1156a = newNearbyActivity;
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
            com.baidu.tieba.util.z.c("onCheckedChanged id = " + String.valueOf(compoundButton.getId()));
            z2 = this.f1156a.C;
            if (!z2) {
                viewPager = this.f1156a.k;
                if (viewPager != null) {
                    viewPager2 = this.f1156a.k;
                    if (viewPager2.getChildCount() >= 2) {
                        this.f1156a.B = true;
                        radioButton = this.f1156a.v;
                        if (compoundButton == radioButton) {
                            viewPager5 = this.f1156a.k;
                            if (viewPager5.getCurrentItem() != 0) {
                                viewPager6 = this.f1156a.k;
                                viewPager6.a(0, true);
                            }
                        } else {
                            viewPager3 = this.f1156a.k;
                            if (viewPager3.getCurrentItem() != 1) {
                                viewPager4 = this.f1156a.k;
                                viewPager4.a(1, true);
                            }
                        }
                        this.f1156a.B = false;
                    }
                }
            }
        }
    }
}
