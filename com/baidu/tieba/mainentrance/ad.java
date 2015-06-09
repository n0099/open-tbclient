package com.baidu.tieba.mainentrance;

import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ SquareSearchActivity bCF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(SquareSearchActivity squareSearchActivity) {
        this.bCF = squareSearchActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        int i;
        int i2;
        FrameLayout frameLayout;
        com.baidu.tbadk.core.view.x xVar;
        com.baidu.tbadk.core.view.x xVar2;
        FrameLayout frameLayout2;
        com.baidu.tbadk.core.view.x xVar3;
        com.baidu.tbadk.core.view.x xVar4;
        boolean z;
        List list;
        FrameLayout frameLayout3;
        com.baidu.tbadk.core.view.x xVar5;
        com.baidu.tbadk.core.view.x xVar6;
        List list2;
        aVar.dismiss();
        i = this.bCF.mMode;
        if (i != 0) {
            i2 = this.bCF.mMode;
            if (i2 == 3) {
                frameLayout2 = this.bCF.bBM;
                frameLayout2.setVisibility(8);
                xVar3 = this.bCF.mNoDataView;
                xVar3.setVisibility(0);
                xVar4 = this.bCF.mNoDataView;
                xVar4.setTextOption(com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.text_no_search_record));
                z = this.bCF.anT;
                if (!z) {
                    RequestSearchPersonHistoryWriteMessage requestSearchPersonHistoryWriteMessage = new RequestSearchPersonHistoryWriteMessage();
                    requestSearchPersonHistoryWriteMessage.setClear(true);
                    this.bCF.sendMessage(requestSearchPersonHistoryWriteMessage);
                    this.bCF.anT = true;
                    return;
                }
                return;
            }
            frameLayout = this.bCF.bBM;
            frameLayout.setVisibility(8);
            xVar = this.bCF.mNoDataView;
            xVar.setVisibility(0);
            xVar2 = this.bCF.mNoDataView;
            xVar2.setTextOption(com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.text_no_search_record));
            com.baidu.tieba.tbadkCore.util.j.apA();
            return;
        }
        com.baidu.adp.lib.g.l.ht().c(new ae(this));
        list = this.bCF.bBF;
        if (list != null) {
            list2 = this.bCF.bBF;
            if (list2.size() > 0) {
                this.bCF.a(4, (ArrayList<String>) null);
                return;
            }
        }
        frameLayout3 = this.bCF.bBM;
        frameLayout3.setVisibility(8);
        xVar5 = this.bCF.mNoDataView;
        xVar5.setVisibility(0);
        xVar6 = this.bCF.mNoDataView;
        xVar6.setTextOption(com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.text_no_search_record));
    }
}
