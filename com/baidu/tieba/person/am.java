package com.baidu.tieba.person;

import android.content.DialogInterface;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonChangeActivity f1320a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PersonChangeActivity personChangeActivity) {
        this.f1320a = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.model.bh bhVar;
        com.baidu.tieba.model.bh bhVar2;
        bhVar = this.f1320a.z;
        if (bhVar.a().getPhotoChanged()) {
            Intent intent = new Intent();
            bhVar2 = this.f1320a.z;
            intent.putExtra("data", bhVar2.a());
            this.f1320a.setResult(-1, intent);
        }
        this.f1320a.finish();
    }
}
