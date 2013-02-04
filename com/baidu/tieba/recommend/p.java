package com.baidu.tieba.recommend;

import android.widget.CompoundButton;
import android.widget.RadioButton;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ NewHomeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(NewHomeActivity newHomeActivity) {
        this.a = newHomeActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        RadioButton radioButton;
        RadioButton radioButton2;
        if (!z) {
            compoundButton.setTextColor(this.a.getResources().getColor(R.color.tab_text_color));
            return;
        }
        compoundButton.setTextColor(this.a.getResources().getColor(R.color.tab_hightlight_text_color));
        radioButton = this.a.e;
        if (compoundButton == radioButton) {
            this.a.a("recommend", RecommendActivity.class);
            return;
        }
        radioButton2 = this.a.f;
        if (compoundButton == radioButton2) {
            this.a.a("guess", GuessActivity.class);
        }
    }
}
