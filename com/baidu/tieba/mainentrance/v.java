package com.baidu.tieba.mainentrance;

import android.content.DialogInterface;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements DialogInterface.OnClickListener {
    final /* synthetic */ u btb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.btb = uVar;
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
        squareSearchActivity = this.btb.bta;
        frameLayout = squareSearchActivity.bsB;
        frameLayout.setVisibility(8);
        squareSearchActivity2 = this.btb.bta;
        xVar = squareSearchActivity2.mNoDataView;
        xVar.setVisibility(0);
        squareSearchActivity3 = this.btb.bta;
        xVar2 = squareSearchActivity3.mNoDataView;
        xVar2.setTextOption(com.baidu.tbadk.core.view.ab.cp(com.baidu.tieba.z.text_no_search_record));
        squareSearchActivity4 = this.btb.bta;
        i2 = squareSearchActivity4.mMode;
        if (i2 != 0) {
            squareSearchActivity5 = this.btb.bta;
            i3 = squareSearchActivity5.mMode;
            if (i3 == 3) {
                squareSearchActivity6 = this.btb.bta;
                z = squareSearchActivity6.aeo;
                if (!z) {
                    RequestSearchPersonHistoryWriteMessage requestSearchPersonHistoryWriteMessage = new RequestSearchPersonHistoryWriteMessage();
                    requestSearchPersonHistoryWriteMessage.setClear(true);
                    squareSearchActivity7 = this.btb.bta;
                    squareSearchActivity7.sendMessage(requestSearchPersonHistoryWriteMessage);
                    squareSearchActivity8 = this.btb.bta;
                    squareSearchActivity8.aeo = true;
                    return;
                }
                return;
            }
            com.baidu.tieba.tbadkCore.util.j.ain();
            return;
        }
        com.baidu.adp.lib.g.l.ek().c(new w(this));
    }
}
