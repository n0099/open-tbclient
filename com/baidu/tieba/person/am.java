package com.baidu.tieba.person;

import android.content.DialogInterface;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonChangeActivity f1572a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PersonChangeActivity personChangeActivity) {
        this.f1572a = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.model.bm bmVar;
        com.baidu.tieba.model.bm bmVar2;
        bmVar = this.f1572a.z;
        if (bmVar.a().getPhotoChanged()) {
            Intent intent = new Intent();
            bmVar2 = this.f1572a.z;
            intent.putExtra("data", bmVar2.a());
            this.f1572a.setResult(-1, intent);
        }
        this.f1572a.finish();
    }
}
