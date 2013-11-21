package com.baidu.tieba.more;

import android.content.DialogInterface;
import android.view.View;
import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
class g implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f1983a;
    final /* synthetic */ f b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, View view) {
        this.b = fVar;
        this.f1983a = view;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        j jVar;
        j jVar2;
        j jVar3;
        j jVar4;
        if (this.f1983a != null) {
            AccountData accountData = (AccountData) this.f1983a.getTag();
            switch (i) {
                case 0:
                    if (accountData != null) {
                        this.b.f1982a.h = new j(this.b.f1982a, false, accountData);
                        jVar3 = this.b.f1982a.h;
                        jVar3.setPriority(3);
                        jVar4 = this.b.f1982a.h;
                        jVar4.execute(new Object[0]);
                    }
                    dialogInterface.cancel();
                    return;
                case 1:
                    if (accountData != null) {
                        this.b.f1982a.h = new j(this.b.f1982a, true, accountData);
                        jVar = this.b.f1982a.h;
                        jVar.setPriority(3);
                        jVar2 = this.b.f1982a.h;
                        jVar2.execute(new Object[0]);
                    }
                    dialogInterface.cancel();
                    return;
                case 2:
                    dialogInterface.cancel();
                    return;
                default:
                    dialogInterface.cancel();
                    return;
            }
        }
    }
}
