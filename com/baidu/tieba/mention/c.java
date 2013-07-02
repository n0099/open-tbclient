package com.baidu.tieba.mention;

import android.widget.CompoundButton;
import android.widget.RadioButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ MentionActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(MentionActivity mentionActivity) {
        this.a = mentionActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        RadioButton radioButton;
        RadioButton radioButton2;
        if (z) {
            radioButton = this.a.f;
            if (compoundButton != radioButton) {
                radioButton2 = this.a.e;
                if (compoundButton == radioButton2) {
                    this.a.a("atme", AtMeActivity.class);
                }
            } else {
                this.a.a("replyme", ReplyMeActivity.class);
            }
        }
        this.a.b();
    }
}
