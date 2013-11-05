package com.baidu.tieba.person;

import android.content.DialogInterface;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonChangeActivity f2176a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PersonChangeActivity personChangeActivity) {
        this.f2176a = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.model.bv bvVar;
        Boolean bool;
        com.baidu.tieba.model.bv bvVar2;
        com.baidu.tieba.model.bv bvVar3;
        bvVar = this.f2176a.A;
        if (bvVar.a().getPhotoChanged()) {
            Intent intent = new Intent();
            bool = this.f2176a.b;
            if (bool.booleanValue()) {
                bvVar3 = this.f2176a.A;
                intent.putExtra("person_change_data", bvVar3.a());
            } else {
                bvVar2 = this.f2176a.A;
                intent.putExtra("data", bvVar2.a());
            }
            this.f2176a.setResult(-1, intent);
        }
        this.f2176a.finish();
    }
}
