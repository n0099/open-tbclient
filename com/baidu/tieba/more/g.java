package com.baidu.tieba.more;

import android.content.DialogInterface;
import android.view.View;
import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
class g implements DialogInterface.OnClickListener {
    final /* synthetic */ f a;
    private final /* synthetic */ View b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, View view) {
        this.a = fVar;
        this.b = view;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AccountActivity accountActivity;
        AccountActivity accountActivity2;
        AccountActivity accountActivity3;
        j jVar;
        AccountActivity accountActivity4;
        j jVar2;
        AccountActivity accountActivity5;
        AccountActivity accountActivity6;
        AccountActivity accountActivity7;
        j jVar3;
        AccountActivity accountActivity8;
        j jVar4;
        if (this.b != null) {
            AccountData accountData = (AccountData) this.b.getTag();
            switch (i) {
                case 0:
                    if (accountData != null) {
                        accountActivity5 = this.a.a;
                        accountActivity6 = this.a.a;
                        accountActivity5.i = new j(accountActivity6, false, accountData);
                        accountActivity7 = this.a.a;
                        jVar3 = accountActivity7.i;
                        jVar3.setPriority(3);
                        accountActivity8 = this.a.a;
                        jVar4 = accountActivity8.i;
                        jVar4.execute(new Object[0]);
                    }
                    dialogInterface.cancel();
                    return;
                case 1:
                    if (accountData != null) {
                        accountActivity = this.a.a;
                        accountActivity2 = this.a.a;
                        accountActivity.i = new j(accountActivity2, true, accountData);
                        accountActivity3 = this.a.a;
                        jVar = accountActivity3.i;
                        jVar.setPriority(3);
                        accountActivity4 = this.a.a;
                        jVar2 = accountActivity4.i;
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
