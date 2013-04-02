package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements DialogInterface.OnClickListener {
    final /* synthetic */ MoreActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(MoreActivity moreActivity) {
        this.a = moreActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int i2;
        int i3;
        switch (i) {
            case 0:
                if (TiebaApplication.b().ah() != 1) {
                    TiebaApplication.b().h(1);
                    this.a.b = 1;
                    MoreActivity moreActivity = this.a;
                    i3 = this.a.b;
                    moreActivity.b(i3);
                    new com.baidu.tieba.account.ak("eyeshield").start();
                    break;
                } else {
                    return;
                }
            case 1:
                if (TiebaApplication.b().ah() != 0) {
                    TiebaApplication.b().h(0);
                    this.a.b = 0;
                    MoreActivity moreActivity2 = this.a;
                    i2 = this.a.b;
                    moreActivity2.b(i2);
                    break;
                } else {
                    return;
                }
        }
        this.a.s();
        this.a.m();
        com.baidu.tieba.c.e.a();
    }
}
