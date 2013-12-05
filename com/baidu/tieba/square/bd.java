package com.baidu.tieba.square;

import android.content.DialogInterface;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class bd implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bb f2500a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bb bbVar) {
        this.f2500a = bbVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int i2;
        i2 = this.f2500a.f2498a.C;
        if (i2 == 0) {
            DatabaseService.q();
            this.f2500a.f2498a.f();
            return;
        }
        DatabaseService.r();
        this.f2500a.f2498a.h();
    }
}
