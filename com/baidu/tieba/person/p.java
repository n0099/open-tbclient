package com.baidu.tieba.person;

import android.widget.CompoundButton;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditHeadActivity f1610a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(EditHeadActivity editHeadActivity) {
        this.f1610a = editHeadActivity;
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
            compoundButton.setTextColor(this.f1610a.getResources().getColor(R.color.white));
            radioButton = this.f1610a.q;
            if (compoundButton == radioButton) {
                horizontalScrollView2 = this.f1610a.m;
                horizontalScrollView2.setVisibility(0);
                linearLayout2 = this.f1610a.s;
                linearLayout2.setVisibility(4);
                return;
            }
            radioButton2 = this.f1610a.r;
            if (compoundButton == radioButton2) {
                horizontalScrollView = this.f1610a.m;
                horizontalScrollView.setVisibility(4);
                linearLayout = this.f1610a.s;
                linearLayout.setVisibility(0);
                return;
            }
            return;
        }
        compoundButton.setTextColor(this.f1610a.getResources().getColor(R.color.beautify_rotate_tab_unchecked_color));
    }
}
