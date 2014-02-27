package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
/* loaded from: classes.dex */
final class bo implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.baidu.tieba.model.bo boVar;
        int i;
        boolean z;
        com.baidu.tieba.model.bo boVar2;
        com.baidu.tieba.model.bo boVar3;
        Boolean bool;
        com.baidu.tieba.model.bo boVar4;
        com.baidu.tieba.model.bo boVar5;
        Dialog dialog;
        boVar = this.a.w;
        int sex = boVar.a().getSex();
        i = this.a.G;
        if (sex != i) {
            this.a.F = true;
        }
        z = this.a.F;
        if (!z) {
            boVar2 = this.a.w;
            if (boVar2 != null) {
                boVar3 = this.a.w;
                if (boVar3.a().getPhotoChanged()) {
                    Intent intent = new Intent();
                    bool = this.a.b;
                    if (bool.booleanValue()) {
                        boVar5 = this.a.w;
                        intent.putExtra("person_change_data", boVar5.a());
                    } else {
                        boVar4 = this.a.w;
                        intent.putExtra("data", boVar4.a());
                    }
                    this.a.setResult(-1, intent);
                }
            }
            this.a.finish();
            return;
        }
        dialog = this.a.D;
        dialog.show();
    }
}
