package com.baidu.tieba.mention;

import android.widget.CompoundButton;
import android.widget.RadioButton;
import com.baidu.tieba.R;
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
        if (!z) {
            compoundButton.setTextColor(this.a.getResources().getColor(R.color.tab_text_color));
            return;
        }
        compoundButton.setTextColor(this.a.getResources().getColor(R.color.tab_hightlight_text_color));
        radioButton = this.a.b;
        if (compoundButton == radioButton) {
            this.a.a("replyme", ReplyMeActivity.class);
            return;
        }
        radioButton2 = this.a.a;
        if (compoundButton == radioButton2) {
            this.a.a("atme", AtMeActivity.class);
        }
    }
}
