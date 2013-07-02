package com.baidu.tieba.person;

import android.content.DialogInterface;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.model.bh bhVar;
        com.baidu.tieba.model.bh bhVar2;
        bhVar = this.a.z;
        if (bhVar.a().getPhotoChanged()) {
            Intent intent = new Intent();
            bhVar2 = this.a.z;
            intent.putExtra("data", bhVar2.a());
            this.a.setResult(-1, intent);
        }
        this.a.finish();
    }
}
