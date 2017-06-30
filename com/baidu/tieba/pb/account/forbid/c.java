package com.baidu.tieba.pb.account.forbid;

import android.widget.RadioGroup;
/* loaded from: classes.dex */
class c implements RadioGroup.OnCheckedChangeListener {
    final /* synthetic */ ForbidActivity epE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ForbidActivity forbidActivity) {
        this.epE = forbidActivity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        RadioGroup radioGroup2;
        ForbidActivity forbidActivity = this.epE;
        radioGroup2 = this.epE.epy;
        forbidActivity.oz(radioGroup2.getCheckedRadioButtonId());
    }
}
