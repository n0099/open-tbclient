package com.baidu.tieba.square;

import android.content.DialogInterface;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class bf implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bd f2400a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(bd bdVar) {
        this.f2400a = bdVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int i2;
        i2 = this.f2400a.f2398a.C;
        if (i2 == 0) {
            DatabaseService.q();
            this.f2400a.f2398a.f();
            return;
        }
        DatabaseService.r();
        this.f2400a.f2398a.h();
    }
}
