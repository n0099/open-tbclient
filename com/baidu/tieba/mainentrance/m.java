package com.baidu.tieba.mainentrance;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class m implements DialogInterface.OnClickListener {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.a = lVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        SquareSearchActivity squareSearchActivity;
        int i2;
        SquareSearchActivity squareSearchActivity2;
        SquareSearchActivity squareSearchActivity3;
        squareSearchActivity = this.a.a;
        i2 = squareSearchActivity.z;
        if (i2 == 0) {
            com.baidu.tieba.util.k.j();
            squareSearchActivity3 = this.a.a;
            squareSearchActivity3.j();
            return;
        }
        com.baidu.tieba.util.k.k();
        squareSearchActivity2 = this.a.a;
        squareSearchActivity2.k();
    }
}
