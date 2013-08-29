package com.baidu.tieba.person;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ap implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonChangeActivity f1611a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(PersonChangeActivity personChangeActivity) {
        this.f1611a = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            com.baidu.tieba.write.ba.a(this.f1611a);
        } else if (i == 1) {
            com.baidu.tieba.write.ba.b(this.f1611a);
        }
    }
}
