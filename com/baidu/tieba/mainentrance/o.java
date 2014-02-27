package com.baidu.tieba.mainentrance;

import android.content.DialogInterface;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
final class o implements DialogInterface.OnClickListener {
    final /* synthetic */ n a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.a = nVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        SquareSearchActivity squareSearchActivity;
        int i2;
        SquareSearchActivity squareSearchActivity2;
        SquareSearchActivity squareSearchActivity3;
        squareSearchActivity = this.a.a;
        i2 = squareSearchActivity.D;
        if (i2 == 0) {
            DatabaseService.o();
            squareSearchActivity3 = this.a.a;
            squareSearchActivity3.c();
            return;
        }
        DatabaseService.p();
        squareSearchActivity2 = this.a.a;
        squareSearchActivity2.d();
    }
}
