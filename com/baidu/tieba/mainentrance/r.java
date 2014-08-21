package com.baidu.tieba.mainentrance;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements DialogInterface.OnClickListener {
    final /* synthetic */ q a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.a = qVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        SquareSearchActivity squareSearchActivity;
        int i2;
        SquareSearchActivity squareSearchActivity2;
        int i3;
        SquareSearchActivity squareSearchActivity3;
        SquareSearchActivity squareSearchActivity4;
        SquareSearchActivity squareSearchActivity5;
        SquareSearchActivity squareSearchActivity6;
        SquareSearchActivity squareSearchActivity7;
        squareSearchActivity = this.a.a;
        i2 = squareSearchActivity.z;
        if (i2 != 0) {
            squareSearchActivity2 = this.a.a;
            i3 = squareSearchActivity2.z;
            if (i3 == 3) {
                RequestSearchPersonHistoryWriteMessage requestSearchPersonHistoryWriteMessage = new RequestSearchPersonHistoryWriteMessage();
                requestSearchPersonHistoryWriteMessage.setClear(true);
                squareSearchActivity4 = this.a.a;
                squareSearchActivity4.sendMessage(requestSearchPersonHistoryWriteMessage);
                squareSearchActivity5 = this.a.a;
                squareSearchActivity5.showProgressBarWithOffset(0, 0);
                squareSearchActivity6 = this.a.a;
                squareSearchActivity6.m();
                return;
            }
            com.baidu.tieba.util.k.i();
            squareSearchActivity3 = this.a.a;
            squareSearchActivity3.l();
            return;
        }
        com.baidu.adp.lib.e.f.a().a(new s(this));
        squareSearchActivity7 = this.a.a;
        squareSearchActivity7.k();
    }
}
