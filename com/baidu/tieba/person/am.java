package com.baidu.tieba.person;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.tieba.model.bw;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonChangeActivity f2218a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PersonChangeActivity personChangeActivity) {
        this.f2218a = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        bw bwVar;
        Boolean bool;
        bw bwVar2;
        bw bwVar3;
        bwVar = this.f2218a.y;
        if (bwVar.a().getPhotoChanged()) {
            Intent intent = new Intent();
            bool = this.f2218a.b;
            if (bool.booleanValue()) {
                bwVar3 = this.f2218a.y;
                intent.putExtra("person_change_data", bwVar3.a());
            } else {
                bwVar2 = this.f2218a.y;
                intent.putExtra("data", bwVar2.a());
            }
            this.f2218a.setResult(-1, intent);
        }
        this.f2218a.finish();
    }
}
