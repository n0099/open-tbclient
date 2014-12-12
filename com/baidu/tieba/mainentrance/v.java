package com.baidu.tieba.mainentrance;

import android.content.DialogInterface;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements DialogInterface.OnClickListener {
    final /* synthetic */ u brG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.brG = uVar;
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
        squareSearchActivity = this.brG.brF;
        frameLayout = squareSearchActivity.bre;
        frameLayout.setVisibility(8);
        squareSearchActivity2 = this.brG.brF;
        xVar = squareSearchActivity2.mNoDataView;
        xVar.setVisibility(0);
        squareSearchActivity3 = this.brG.brF;
        xVar2 = squareSearchActivity3.mNoDataView;
        xVar2.setTextOption(com.baidu.tbadk.core.view.ab.ci(com.baidu.tieba.z.text_no_search_record));
        squareSearchActivity4 = this.brG.brF;
        i2 = squareSearchActivity4.mMode;
        if (i2 != 0) {
            squareSearchActivity5 = this.brG.brF;
            i3 = squareSearchActivity5.mMode;
            if (i3 == 3) {
                squareSearchActivity6 = this.brG.brF;
                z = squareSearchActivity6.adU;
                if (!z) {
                    RequestSearchPersonHistoryWriteMessage requestSearchPersonHistoryWriteMessage = new RequestSearchPersonHistoryWriteMessage();
                    requestSearchPersonHistoryWriteMessage.setClear(true);
                    squareSearchActivity7 = this.brG.brF;
                    squareSearchActivity7.sendMessage(requestSearchPersonHistoryWriteMessage);
                    squareSearchActivity8 = this.brG.brF;
                    squareSearchActivity8.adU = true;
                    return;
                }
                return;
            }
            com.baidu.tieba.tbadkCore.util.j.ahO();
            return;
        }
        com.baidu.adp.lib.g.l.em().c(new w(this));
    }
}
