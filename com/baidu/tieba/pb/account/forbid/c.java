package com.baidu.tieba.pb.account.forbid;

import android.widget.RadioGroup;
/* loaded from: classes.dex */
class c implements RadioGroup.OnCheckedChangeListener {
    final /* synthetic */ ForbidActivity eel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ForbidActivity forbidActivity) {
        this.eel = forbidActivity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        RadioGroup radioGroup2;
        ForbidActivity forbidActivity = this.eel;
        radioGroup2 = this.eel.eef;
        forbidActivity.nW(radioGroup2.getCheckedRadioButtonId());
    }
}
