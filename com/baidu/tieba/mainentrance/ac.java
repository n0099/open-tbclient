package com.baidu.tieba.mainentrance;

import android.widget.ScrollView;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements a.b {
    final /* synthetic */ SquareSearchActivity bQZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(SquareSearchActivity squareSearchActivity) {
        this.bQZ = squareSearchActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ScrollView scrollView;
        ScrollView scrollView2;
        boolean z;
        List list;
        ScrollView scrollView3;
        SearchPageFocusBar searchPageFocusBar;
        List list2;
        aVar.dismiss();
        if (this.bQZ.mMode != 0) {
            if (this.bQZ.mMode == 3) {
                this.bQZ.bQa.setVisibility(8);
                SquareSearchActivity squareSearchActivity = this.bQZ;
                scrollView2 = this.bQZ.bQF;
                squareSearchActivity.P(scrollView2);
                this.bQZ.mNoDataView.setVisibility(0);
                this.bQZ.mNoDataView.setTextOption(NoDataViewFactory.d.cD(i.C0057i.text_no_search_record));
                z = this.bQZ.avj;
                if (!z) {
                    RequestSearchPersonHistoryWriteMessage requestSearchPersonHistoryWriteMessage = new RequestSearchPersonHistoryWriteMessage();
                    requestSearchPersonHistoryWriteMessage.setClear(true);
                    this.bQZ.sendMessage(requestSearchPersonHistoryWriteMessage);
                    this.bQZ.avj = true;
                    return;
                }
                return;
            }
            SquareSearchActivity squareSearchActivity2 = this.bQZ;
            scrollView = this.bQZ.bQF;
            squareSearchActivity2.P(scrollView);
            this.bQZ.bQa.setVisibility(8);
            this.bQZ.mNoDataView.setVisibility(0);
            this.bQZ.mNoDataView.setTextOption(NoDataViewFactory.d.cD(i.C0057i.text_no_search_record));
            com.baidu.tieba.tbadkCore.util.k.aqU();
            return;
        }
        com.baidu.adp.lib.g.k.hj().c(new ad(this));
        list = this.bQZ.bPO;
        if (list != null) {
            list2 = this.bQZ.bPO;
            if (list2.size() > 0) {
                this.bQZ.a(4, (ArrayList<String>) null);
                return;
            }
        }
        SquareSearchActivity squareSearchActivity3 = this.bQZ;
        scrollView3 = this.bQZ.bQF;
        squareSearchActivity3.P(scrollView3);
        SquareSearchActivity squareSearchActivity4 = this.bQZ;
        searchPageFocusBar = this.bQZ.bQG;
        squareSearchActivity4.P(searchPageFocusBar);
        this.bQZ.bQa.setVisibility(8);
        this.bQZ.mNoDataView.setVisibility(0);
        this.bQZ.mNoDataView.setTextOption(NoDataViewFactory.d.cD(i.C0057i.text_no_search_record));
    }
}
