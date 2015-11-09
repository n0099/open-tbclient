package com.baidu.tieba.mainentrance;

import android.widget.ScrollView;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.i;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements a.b {
    final /* synthetic */ SquareSearchActivity bWd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(SquareSearchActivity squareSearchActivity) {
        this.bWd = squareSearchActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0042, code lost:
        if (r0.size() >= 2) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0044, code lost:
        r6.bWd.a(4, (java.util.ArrayList<java.lang.String>) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004b, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002e, code lost:
        if (r0.size() < 2) goto L10;
     */
    @Override // com.baidu.tbadk.core.dialog.a.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ScrollView scrollView;
        ScrollView scrollView2;
        boolean z;
        List list;
        List list2;
        ScrollView scrollView3;
        SearchPageFocusBar searchPageFocusBar;
        List list3;
        List list4;
        aVar.dismiss();
        if (this.bWd.mMode != 0) {
            if (this.bWd.mMode == 3) {
                this.bWd.bVa.setVisibility(8);
                SquareSearchActivity squareSearchActivity = this.bWd;
                scrollView2 = this.bWd.bVI;
                squareSearchActivity.Q(scrollView2);
                this.bWd.mNoDataView.setVisibility(0);
                this.bWd.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.text_no_search_record));
                z = this.bWd.auf;
                if (!z) {
                    RequestSearchPersonHistoryWriteMessage requestSearchPersonHistoryWriteMessage = new RequestSearchPersonHistoryWriteMessage();
                    requestSearchPersonHistoryWriteMessage.setClear(true);
                    this.bWd.sendMessage(requestSearchPersonHistoryWriteMessage);
                    this.bWd.auf = true;
                    return;
                }
                return;
            }
            SquareSearchActivity squareSearchActivity2 = this.bWd;
            scrollView = this.bWd.bVI;
            squareSearchActivity2.Q(scrollView);
            this.bWd.bVa.setVisibility(8);
            this.bWd.mNoDataView.setVisibility(0);
            this.bWd.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.text_no_search_record));
            com.baidu.tieba.tbadkCore.util.m.ayK();
            return;
        }
        com.baidu.adp.lib.g.k.hi().c(new aj(this));
        list = this.bWd.bUJ;
        if (list != null) {
            list4 = this.bWd.bUJ;
        }
        list2 = this.bWd.bVj;
        if (list2 != null) {
            list3 = this.bWd.bVj;
        }
        SquareSearchActivity squareSearchActivity3 = this.bWd;
        scrollView3 = this.bWd.bVI;
        squareSearchActivity3.Q(scrollView3);
        SquareSearchActivity squareSearchActivity4 = this.bWd;
        searchPageFocusBar = this.bWd.bVJ;
        squareSearchActivity4.Q(searchPageFocusBar);
        this.bWd.bVa.setVisibility(8);
        this.bWd.mNoDataView.setVisibility(0);
        this.bWd.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.text_no_search_record));
    }
}
