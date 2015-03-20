package com.baidu.tieba.setting.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity ccF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PersonChangeActivity personChangeActivity) {
        this.ccF = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.ccF.hW(300);
    }
}
