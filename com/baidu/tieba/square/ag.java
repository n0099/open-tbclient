package com.baidu.tieba.square;

import android.content.DialogInterface;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class ag implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ae f2339a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ae aeVar) {
        this.f2339a = aeVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int i2;
        i2 = this.f2339a.f2337a.F;
        if (i2 == 0) {
            DatabaseService.q();
            this.f2339a.f2337a.n();
            return;
        }
        DatabaseService.r();
        this.f2339a.f2337a.p();
    }
}
