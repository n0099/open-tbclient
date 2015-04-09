package com.baidu.tieba.mainentrance;

import android.widget.FrameLayout;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ ab bzU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.bzU = abVar;
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
        squareSearchActivity = this.bzU.bzT;
        i = squareSearchActivity.mMode;
        if (i != 0) {
            squareSearchActivity2 = this.bzU.bzT;
            i2 = squareSearchActivity2.mMode;
            if (i2 == 3) {
                squareSearchActivity6 = this.bzU.bzT;
                frameLayout2 = squareSearchActivity6.bzd;
                frameLayout2.setVisibility(8);
                squareSearchActivity7 = this.bzU.bzT;
                sVar3 = squareSearchActivity7.mNoDataView;
                sVar3.setVisibility(0);
                squareSearchActivity8 = this.bzU.bzT;
                sVar4 = squareSearchActivity8.mNoDataView;
                sVar4.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.text_no_search_record));
                squareSearchActivity9 = this.bzU.bzT;
                z = squareSearchActivity9.amQ;
                if (!z) {
                    RequestSearchPersonHistoryWriteMessage requestSearchPersonHistoryWriteMessage = new RequestSearchPersonHistoryWriteMessage();
                    requestSearchPersonHistoryWriteMessage.setClear(true);
                    squareSearchActivity10 = this.bzU.bzT;
                    squareSearchActivity10.sendMessage(requestSearchPersonHistoryWriteMessage);
                    squareSearchActivity11 = this.bzU.bzT;
                    squareSearchActivity11.amQ = true;
                    return;
                }
                return;
            }
            squareSearchActivity3 = this.bzU.bzT;
            frameLayout = squareSearchActivity3.bzd;
            frameLayout.setVisibility(8);
            squareSearchActivity4 = this.bzU.bzT;
            sVar = squareSearchActivity4.mNoDataView;
            sVar.setVisibility(0);
            squareSearchActivity5 = this.bzU.bzT;
            sVar2 = squareSearchActivity5.mNoDataView;
            sVar2.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.text_no_search_record));
            com.baidu.tieba.tbadkCore.util.j.anH();
            return;
        }
        com.baidu.adp.lib.g.l.hJ().c(new ad(this));
        squareSearchActivity12 = this.bzU.bzT;
        z2 = squareSearchActivity12.bzG;
        if (z2) {
            squareSearchActivity16 = this.bzU.bzT;
            squareSearchActivity16.a(4, (ArrayList<String>) null);
            return;
        }
        squareSearchActivity13 = this.bzU.bzT;
        frameLayout3 = squareSearchActivity13.bzd;
        frameLayout3.setVisibility(8);
        squareSearchActivity14 = this.bzU.bzT;
        sVar5 = squareSearchActivity14.mNoDataView;
        sVar5.setVisibility(0);
        squareSearchActivity15 = this.bzU.bzT;
        sVar6 = squareSearchActivity15.mNoDataView;
        sVar6.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.text_no_search_record));
    }
}
