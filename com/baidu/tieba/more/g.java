package com.baidu.tieba.more;

import android.content.DialogInterface;
import android.view.View;
import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
class g implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f2090a;
    final /* synthetic */ f b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, View view) {
        this.b = fVar;
        this.f2090a = view;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        j jVar;
        j jVar2;
        j jVar3;
        j jVar4;
        if (this.f2090a != null) {
            AccountData accountData = (AccountData) this.f2090a.getTag();
            switch (i) {
                case 0:
                    if (accountData != null) {
                        this.b.f2089a.h = new j(this.b.f2089a, false, accountData);
                        jVar3 = this.b.f2089a.h;
                        jVar3.setPriority(3);
                        jVar4 = this.b.f2089a.h;
                        jVar4.execute(new Object[0]);
                    }
                    dialogInterface.cancel();
                    return;
                case 1:
                    if (accountData != null) {
                        this.b.f2089a.h = new j(this.b.f2089a, true, accountData);
                        jVar = this.b.f2089a.h;
                        jVar.setPriority(3);
                        jVar2 = this.b.f2089a.h;
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
