package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity bHL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(PersonChangeActivity personChangeActivity) {
        this.bHL = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bHL.hp(300);
    }
}
