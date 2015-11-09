package com.baidu.tieba.pb.account.forbid;

import android.widget.RadioGroup;
/* loaded from: classes.dex */
class c implements RadioGroup.OnCheckedChangeListener {
    final /* synthetic */ ForbidActivity cff;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ForbidActivity forbidActivity) {
        this.cff = forbidActivity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        RadioGroup radioGroup2;
        ForbidActivity forbidActivity = this.cff;
        radioGroup2 = this.cff.cfa;
        forbidActivity.iS(radioGroup2.getCheckedRadioButtonId());
    }
}
