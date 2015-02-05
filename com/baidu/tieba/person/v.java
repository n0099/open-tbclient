package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity bHK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(PersonChangeActivity personChangeActivity) {
        this.bHK = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bHK.hp(300);
    }
}
