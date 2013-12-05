package com.baidu.tieba.person;

import android.widget.CompoundButton;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditHeadActivity f2390a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(EditHeadActivity editHeadActivity) {
        this.f2390a = editHeadActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        RadioButton radioButton;
        RadioButton radioButton2;
        HorizontalScrollView horizontalScrollView;
        LinearLayout linearLayout;
        HorizontalScrollView horizontalScrollView2;
        LinearLayout linearLayout2;
        if (z) {
            compoundButton.setTextColor(this.f2390a.getResources().getColor(R.color.white));
            radioButton = this.f2390a.r;
            if (compoundButton == radioButton) {
                horizontalScrollView2 = this.f2390a.n;
                horizontalScrollView2.setVisibility(0);
                linearLayout2 = this.f2390a.t;
                linearLayout2.setVisibility(4);
                return;
            }
            radioButton2 = this.f2390a.s;
            if (compoundButton == radioButton2) {
                horizontalScrollView = this.f2390a.n;
                horizontalScrollView.setVisibility(4);
                linearLayout = this.f2390a.t;
                linearLayout.setVisibility(0);
                return;
            }
            return;
        }
        compoundButton.setTextColor(this.f2390a.getResources().getColor(R.color.beautify_rotate_tab_unchecked_color));
    }
}
