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
    final /* synthetic */ SquareSearchActivity bRF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(SquareSearchActivity squareSearchActivity) {
        this.bRF = squareSearchActivity;
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
        if (this.bRF.mMode != 0) {
            if (this.bRF.mMode == 3) {
                this.bRF.bQG.setVisibility(8);
                SquareSearchActivity squareSearchActivity = this.bRF;
                scrollView2 = this.bRF.bRl;
                squareSearchActivity.P(scrollView2);
                this.bRF.mNoDataView.setVisibility(0);
                this.bRF.mNoDataView.setTextOption(NoDataViewFactory.d.cJ(i.h.text_no_search_record));
                z = this.bRF.awR;
                if (!z) {
                    RequestSearchPersonHistoryWriteMessage requestSearchPersonHistoryWriteMessage = new RequestSearchPersonHistoryWriteMessage();
                    requestSearchPersonHistoryWriteMessage.setClear(true);
                    this.bRF.sendMessage(requestSearchPersonHistoryWriteMessage);
                    this.bRF.awR = true;
                    return;
                }
                return;
            }
            SquareSearchActivity squareSearchActivity2 = this.bRF;
            scrollView = this.bRF.bRl;
            squareSearchActivity2.P(scrollView);
            this.bRF.bQG.setVisibility(8);
            this.bRF.mNoDataView.setVisibility(0);
            this.bRF.mNoDataView.setTextOption(NoDataViewFactory.d.cJ(i.h.text_no_search_record));
            com.baidu.tieba.tbadkCore.util.k.avi();
            return;
        }
        com.baidu.adp.lib.g.k.hg().c(new ad(this));
        list = this.bRF.bQu;
        if (list != null) {
            list2 = this.bRF.bQu;
            if (list2.size() > 0) {
                this.bRF.a(4, (ArrayList<String>) null);
                return;
            }
        }
        SquareSearchActivity squareSearchActivity3 = this.bRF;
        scrollView3 = this.bRF.bRl;
        squareSearchActivity3.P(scrollView3);
        SquareSearchActivity squareSearchActivity4 = this.bRF;
        searchPageFocusBar = this.bRF.bRm;
        squareSearchActivity4.P(searchPageFocusBar);
        this.bRF.bQG.setVisibility(8);
        this.bRF.mNoDataView.setVisibility(0);
        this.bRF.mNoDataView.setTextOption(NoDataViewFactory.d.cJ(i.h.text_no_search_record));
    }
}
