package com.baidu.tieba.mainentrance;

import android.content.DialogInterface;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements DialogInterface.OnClickListener {
    final /* synthetic */ t bnd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.bnd = tVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        SquareSearchActivity squareSearchActivity;
        FrameLayout frameLayout;
        SquareSearchActivity squareSearchActivity2;
        com.baidu.tbadk.core.view.o oVar;
        SquareSearchActivity squareSearchActivity3;
        com.baidu.tbadk.core.view.o oVar2;
        SquareSearchActivity squareSearchActivity4;
        int i2;
        SquareSearchActivity squareSearchActivity5;
        int i3;
        SquareSearchActivity squareSearchActivity6;
        boolean z;
        SquareSearchActivity squareSearchActivity7;
        SquareSearchActivity squareSearchActivity8;
        squareSearchActivity = this.bnd.bnc;
        frameLayout = squareSearchActivity.bmB;
        frameLayout.setVisibility(8);
        squareSearchActivity2 = this.bnd.bnc;
        oVar = squareSearchActivity2.ahX;
        oVar.setVisibility(0);
        squareSearchActivity3 = this.bnd.bnc;
        oVar2 = squareSearchActivity3.ahX;
        oVar2.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.text_no_search_record));
        squareSearchActivity4 = this.bnd.bnc;
        i2 = squareSearchActivity4.mMode;
        if (i2 != 0) {
            squareSearchActivity5 = this.bnd.bnc;
            i3 = squareSearchActivity5.mMode;
            if (i3 == 3) {
                squareSearchActivity6 = this.bnd.bnc;
                z = squareSearchActivity6.XM;
                if (!z) {
                    RequestSearchPersonHistoryWriteMessage requestSearchPersonHistoryWriteMessage = new RequestSearchPersonHistoryWriteMessage();
                    requestSearchPersonHistoryWriteMessage.setClear(true);
                    squareSearchActivity7 = this.bnd.bnc;
                    squareSearchActivity7.sendMessage(requestSearchPersonHistoryWriteMessage);
                    squareSearchActivity8 = this.bnd.bnc;
                    squareSearchActivity8.XM = true;
                    return;
                }
                return;
            }
            com.baidu.tieba.util.j.aeH();
            return;
        }
        com.baidu.adp.lib.g.k.el().b(new v(this));
    }
}
