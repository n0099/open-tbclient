package com.baidu.tieba.mention;

import android.widget.CompoundButton;
import android.widget.RadioButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MentionActivity f1292a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(MentionActivity mentionActivity) {
        this.f1292a = mentionActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        RadioButton radioButton;
        RadioButton radioButton2;
        if (z) {
            radioButton = this.f1292a.f;
            if (compoundButton != radioButton) {
                radioButton2 = this.f1292a.e;
                if (compoundButton == radioButton2) {
                    this.f1292a.a("atme", AtMeActivity.class);
                }
            } else {
                this.f1292a.a("replyme", ReplyMeActivity.class);
            }
        }
        this.f1292a.b();
    }
}
