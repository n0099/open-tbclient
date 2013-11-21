package com.baidu.tieba.person;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.tieba.model.bw;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonChangeActivity f2203a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PersonChangeActivity personChangeActivity) {
        this.f2203a = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        bw bwVar;
        Boolean bool;
        bw bwVar2;
        bw bwVar3;
        bwVar = this.f2203a.y;
        if (bwVar.a().getPhotoChanged()) {
            Intent intent = new Intent();
            bool = this.f2203a.b;
            if (bool.booleanValue()) {
                bwVar3 = this.f2203a.y;
                intent.putExtra("person_change_data", bwVar3.a());
            } else {
                bwVar2 = this.f2203a.y;
                intent.putExtra("data", bwVar2.a());
            }
            this.f2203a.setResult(-1, intent);
        }
        this.f2203a.finish();
    }
}
