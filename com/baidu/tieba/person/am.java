package com.baidu.tieba.person;

import android.content.DialogInterface;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonChangeActivity f1608a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PersonChangeActivity personChangeActivity) {
        this.f1608a = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.model.bl blVar;
        Boolean bool;
        com.baidu.tieba.model.bl blVar2;
        com.baidu.tieba.model.bl blVar3;
        blVar = this.f1608a.A;
        if (blVar.a().getPhotoChanged()) {
            Intent intent = new Intent();
            bool = this.f1608a.f1592a;
            if (bool.booleanValue()) {
                blVar3 = this.f1608a.A;
                intent.putExtra("person_change_data", blVar3.a());
            } else {
                blVar2 = this.f1608a.A;
                intent.putExtra("data", blVar2.a());
            }
            this.f1608a.setResult(-1, intent);
        }
        this.f1608a.finish();
    }
}
