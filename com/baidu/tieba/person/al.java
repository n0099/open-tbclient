package com.baidu.tieba.person;

import android.content.DialogInterface;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonChangeActivity f1657a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PersonChangeActivity personChangeActivity) {
        this.f1657a = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.model.bn bnVar;
        Boolean bool;
        com.baidu.tieba.model.bn bnVar2;
        com.baidu.tieba.model.bn bnVar3;
        bnVar = this.f1657a.A;
        if (bnVar.a().getPhotoChanged()) {
            Intent intent = new Intent();
            bool = this.f1657a.b;
            if (bool.booleanValue()) {
                bnVar3 = this.f1657a.A;
                intent.putExtra("person_change_data", bnVar3.a());
            } else {
                bnVar2 = this.f1657a.A;
                intent.putExtra("data", bnVar2.a());
            }
            this.f1657a.setResult(-1, intent);
        }
        this.f1657a.finish();
    }
}
