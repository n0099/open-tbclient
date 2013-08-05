package com.baidu.tieba.mention;

import android.widget.CompoundButton;
import android.widget.RadioButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MentionActivity f1294a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(MentionActivity mentionActivity) {
        this.f1294a = mentionActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        RadioButton radioButton;
        RadioButton radioButton2;
        if (z) {
            radioButton = this.f1294a.f;
            if (compoundButton != radioButton) {
                radioButton2 = this.f1294a.e;
                if (compoundButton == radioButton2) {
                    this.f1294a.a("atme", AtMeActivity.class);
                }
            } else {
                this.f1294a.a("replyme", ReplyMeActivity.class);
            }
        }
        this.f1294a.b();
    }
}
