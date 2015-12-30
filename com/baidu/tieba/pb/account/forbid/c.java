package com.baidu.tieba.pb.account.forbid;

import android.widget.RadioGroup;
/* loaded from: classes.dex */
class c implements RadioGroup.OnCheckedChangeListener {
    final /* synthetic */ ForbidActivity cBm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ForbidActivity forbidActivity) {
        this.cBm = forbidActivity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        RadioGroup radioGroup2;
        ForbidActivity forbidActivity = this.cBm;
        radioGroup2 = this.cBm.cBh;
        forbidActivity.kh(radioGroup2.getCheckedRadioButtonId());
    }
}
