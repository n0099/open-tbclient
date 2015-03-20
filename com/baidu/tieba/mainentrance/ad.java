package com.baidu.tieba.mainentrance;

import android.widget.FrameLayout;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ ac bzH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar) {
        this.bzH = acVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        SquareSearchActivity squareSearchActivity;
        int i;
        SquareSearchActivity squareSearchActivity2;
        int i2;
        SquareSearchActivity squareSearchActivity3;
        FrameLayout frameLayout;
        SquareSearchActivity squareSearchActivity4;
        com.baidu.tbadk.core.view.s sVar;
        SquareSearchActivity squareSearchActivity5;
        com.baidu.tbadk.core.view.s sVar2;
        SquareSearchActivity squareSearchActivity6;
        FrameLayout frameLayout2;
        SquareSearchActivity squareSearchActivity7;
        com.baidu.tbadk.core.view.s sVar3;
        SquareSearchActivity squareSearchActivity8;
        com.baidu.tbadk.core.view.s sVar4;
        SquareSearchActivity squareSearchActivity9;
        boolean z;
        SquareSearchActivity squareSearchActivity10;
        SquareSearchActivity squareSearchActivity11;
        SquareSearchActivity squareSearchActivity12;
        boolean z2;
        SquareSearchActivity squareSearchActivity13;
        FrameLayout frameLayout3;
        SquareSearchActivity squareSearchActivity14;
        com.baidu.tbadk.core.view.s sVar5;
        SquareSearchActivity squareSearchActivity15;
        com.baidu.tbadk.core.view.s sVar6;
        SquareSearchActivity squareSearchActivity16;
        aVar.dismiss();
        squareSearchActivity = this.bzH.bzG;
        i = squareSearchActivity.mMode;
        if (i != 0) {
            squareSearchActivity2 = this.bzH.bzG;
            i2 = squareSearchActivity2.mMode;
            if (i2 == 3) {
                squareSearchActivity6 = this.bzH.bzG;
                frameLayout2 = squareSearchActivity6.byR;
                frameLayout2.setVisibility(8);
                squareSearchActivity7 = this.bzH.bzG;
                sVar3 = squareSearchActivity7.mNoDataView;
                sVar3.setVisibility(0);
                squareSearchActivity8 = this.bzH.bzG;
                sVar4 = squareSearchActivity8.mNoDataView;
                sVar4.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.text_no_search_record));
                squareSearchActivity9 = this.bzH.bzG;
                z = squareSearchActivity9.amI;
                if (!z) {
                    RequestSearchPersonHistoryWriteMessage requestSearchPersonHistoryWriteMessage = new RequestSearchPersonHistoryWriteMessage();
                    requestSearchPersonHistoryWriteMessage.setClear(true);
                    squareSearchActivity10 = this.bzH.bzG;
                    squareSearchActivity10.sendMessage(requestSearchPersonHistoryWriteMessage);
                    squareSearchActivity11 = this.bzH.bzG;
                    squareSearchActivity11.amI = true;
                    return;
                }
                return;
            }
            squareSearchActivity3 = this.bzH.bzG;
            frameLayout = squareSearchActivity3.byR;
            frameLayout.setVisibility(8);
            squareSearchActivity4 = this.bzH.bzG;
            sVar = squareSearchActivity4.mNoDataView;
            sVar.setVisibility(0);
            squareSearchActivity5 = this.bzH.bzG;
            sVar2 = squareSearchActivity5.mNoDataView;
            sVar2.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.text_no_search_record));
            com.baidu.tieba.tbadkCore.util.j.ans();
            return;
        }
        com.baidu.adp.lib.g.l.hJ().c(new ae(this));
        squareSearchActivity12 = this.bzH.bzG;
        z2 = squareSearchActivity12.bzt;
        if (z2) {
            squareSearchActivity16 = this.bzH.bzG;
            squareSearchActivity16.a(4, (ArrayList<String>) null);
            return;
        }
        squareSearchActivity13 = this.bzH.bzG;
        frameLayout3 = squareSearchActivity13.byR;
        frameLayout3.setVisibility(8);
        squareSearchActivity14 = this.bzH.bzG;
        sVar5 = squareSearchActivity14.mNoDataView;
        sVar5.setVisibility(0);
        squareSearchActivity15 = this.bzH.bzG;
        sVar6 = squareSearchActivity15.mNoDataView;
        sVar6.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.text_no_search_record));
    }
}
