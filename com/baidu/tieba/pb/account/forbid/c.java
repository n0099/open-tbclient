package com.baidu.tieba.pb.account.forbid;

import android.widget.RadioGroup;
/* loaded from: classes.dex */
class c implements RadioGroup.OnCheckedChangeListener {
    final /* synthetic */ ForbidActivity bIE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ForbidActivity forbidActivity) {
        this.bIE = forbidActivity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        RadioGroup radioGroup2;
        ForbidActivity forbidActivity = this.bIE;
        radioGroup2 = this.bIE.bIz;
        forbidActivity.ht(radioGroup2.getCheckedRadioButtonId());
    }
}
