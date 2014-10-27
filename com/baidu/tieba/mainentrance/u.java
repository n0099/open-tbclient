package com.baidu.tieba.mainentrance;

import android.content.DialogInterface;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements DialogInterface.OnClickListener {
    final /* synthetic */ t bmP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.bmP = tVar;
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
        squareSearchActivity = this.bmP.bmO;
        frameLayout = squareSearchActivity.bmn;
        frameLayout.setVisibility(8);
        squareSearchActivity2 = this.bmP.bmO;
        oVar = squareSearchActivity2.ahO;
        oVar.setVisibility(0);
        squareSearchActivity3 = this.bmP.bmO;
        oVar2 = squareSearchActivity3.ahO;
        oVar2.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.text_no_search_record));
        squareSearchActivity4 = this.bmP.bmO;
        i2 = squareSearchActivity4.mMode;
        if (i2 != 0) {
            squareSearchActivity5 = this.bmP.bmO;
            i3 = squareSearchActivity5.mMode;
            if (i3 == 3) {
                squareSearchActivity6 = this.bmP.bmO;
                z = squareSearchActivity6.XI;
                if (!z) {
                    RequestSearchPersonHistoryWriteMessage requestSearchPersonHistoryWriteMessage = new RequestSearchPersonHistoryWriteMessage();
                    requestSearchPersonHistoryWriteMessage.setClear(true);
                    squareSearchActivity7 = this.bmP.bmO;
                    squareSearchActivity7.sendMessage(requestSearchPersonHistoryWriteMessage);
                    squareSearchActivity8 = this.bmP.bmO;
                    squareSearchActivity8.XI = true;
                    return;
                }
                return;
            }
            com.baidu.tieba.util.j.aeE();
            return;
        }
        com.baidu.adp.lib.g.k.el().b(new v(this));
    }
}
