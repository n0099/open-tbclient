package com.baidu.tieba.mainentrance;

import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ SquareSearchActivity bCE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(SquareSearchActivity squareSearchActivity) {
        this.bCE = squareSearchActivity;
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
        i = this.bCE.mMode;
        if (i != 0) {
            i2 = this.bCE.mMode;
            if (i2 == 3) {
                frameLayout2 = this.bCE.bBL;
                frameLayout2.setVisibility(8);
                xVar3 = this.bCE.mNoDataView;
                xVar3.setVisibility(0);
                xVar4 = this.bCE.mNoDataView;
                xVar4.setTextOption(com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.text_no_search_record));
                z = this.bCE.anT;
                if (!z) {
                    RequestSearchPersonHistoryWriteMessage requestSearchPersonHistoryWriteMessage = new RequestSearchPersonHistoryWriteMessage();
                    requestSearchPersonHistoryWriteMessage.setClear(true);
                    this.bCE.sendMessage(requestSearchPersonHistoryWriteMessage);
                    this.bCE.anT = true;
                    return;
                }
                return;
            }
            frameLayout = this.bCE.bBL;
            frameLayout.setVisibility(8);
            xVar = this.bCE.mNoDataView;
            xVar.setVisibility(0);
            xVar2 = this.bCE.mNoDataView;
            xVar2.setTextOption(com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.text_no_search_record));
            com.baidu.tieba.tbadkCore.util.j.apz();
            return;
        }
        com.baidu.adp.lib.g.l.ht().c(new ae(this));
        list = this.bCE.bBE;
        if (list != null) {
            list2 = this.bCE.bBE;
            if (list2.size() > 0) {
                this.bCE.a(4, (ArrayList<String>) null);
                return;
            }
        }
        frameLayout3 = this.bCE.bBL;
        frameLayout3.setVisibility(8);
        xVar5 = this.bCE.mNoDataView;
        xVar5.setVisibility(0);
        xVar6 = this.bCE.mNoDataView;
        xVar6.setTextOption(com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.text_no_search_record));
    }
}
