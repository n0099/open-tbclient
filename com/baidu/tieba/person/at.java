package com.baidu.tieba.person;

import android.content.DialogInterface;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.model.bw bwVar;
        Boolean bool;
        com.baidu.tieba.model.bw bwVar2;
        com.baidu.tieba.model.bw bwVar3;
        bwVar = this.a.y;
        if (bwVar.a().getPhotoChanged()) {
            Intent intent = new Intent();
            bool = this.a.b;
            if (bool.booleanValue()) {
                bwVar3 = this.a.y;
                intent.putExtra("person_change_data", bwVar3.a());
            } else {
                bwVar2 = this.a.y;
                intent.putExtra("data", bwVar2.a());
            }
            this.a.setResult(-1, intent);
        }
        this.a.finish();
    }
}
