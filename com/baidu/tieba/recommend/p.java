package com.baidu.tieba.recommend;

import android.widget.CompoundButton;
import android.widget.RadioButton;
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
        if (z) {
            radioButton = this.a.f;
            if (compoundButton != radioButton) {
                radioButton2 = this.a.g;
                if (compoundButton == radioButton2) {
                    this.a.a("guess", GuessActivity.class);
                    return;
                }
                return;
            }
            this.a.a("recommend", RecommendActivity.class);
        }
    }
}
