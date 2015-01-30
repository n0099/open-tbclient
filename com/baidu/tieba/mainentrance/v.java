package com.baidu.tieba.mainentrance;

import android.content.DialogInterface;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements DialogInterface.OnClickListener {
    final /* synthetic */ u btc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.btc = uVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        SquareSearchActivity squareSearchActivity;
        FrameLayout frameLayout;
        SquareSearchActivity squareSearchActivity2;
        com.baidu.tbadk.core.view.x xVar;
        SquareSearchActivity squareSearchActivity3;
        com.baidu.tbadk.core.view.x xVar2;
        SquareSearchActivity squareSearchActivity4;
        int i2;
        SquareSearchActivity squareSearchActivity5;
        int i3;
        SquareSearchActivity squareSearchActivity6;
        boolean z;
        SquareSearchActivity squareSearchActivity7;
        SquareSearchActivity squareSearchActivity8;
        squareSearchActivity = this.btc.btb;
        frameLayout = squareSearchActivity.bsC;
        frameLayout.setVisibility(8);
        squareSearchActivity2 = this.btc.btb;
        xVar = squareSearchActivity2.mNoDataView;
        xVar.setVisibility(0);
        squareSearchActivity3 = this.btc.btb;
        xVar2 = squareSearchActivity3.mNoDataView;
        xVar2.setTextOption(com.baidu.tbadk.core.view.ab.cp(com.baidu.tieba.z.text_no_search_record));
        squareSearchActivity4 = this.btc.btb;
        i2 = squareSearchActivity4.mMode;
        if (i2 != 0) {
            squareSearchActivity5 = this.btc.btb;
            i3 = squareSearchActivity5.mMode;
            if (i3 == 3) {
                squareSearchActivity6 = this.btc.btb;
                z = squareSearchActivity6.aer;
                if (!z) {
                    RequestSearchPersonHistoryWriteMessage requestSearchPersonHistoryWriteMessage = new RequestSearchPersonHistoryWriteMessage();
                    requestSearchPersonHistoryWriteMessage.setClear(true);
                    squareSearchActivity7 = this.btc.btb;
                    squareSearchActivity7.sendMessage(requestSearchPersonHistoryWriteMessage);
                    squareSearchActivity8 = this.btc.btb;
                    squareSearchActivity8.aer = true;
                    return;
                }
                return;
            }
            com.baidu.tieba.tbadkCore.util.j.ais();
            return;
        }
        com.baidu.adp.lib.g.l.ek().c(new w(this));
    }
}
