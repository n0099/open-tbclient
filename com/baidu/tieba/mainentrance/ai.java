package com.baidu.tieba.mainentrance;

import android.widget.ScrollView;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.i;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements a.b {
    final /* synthetic */ SquareSearchActivity bVr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(SquareSearchActivity squareSearchActivity) {
        this.bVr = squareSearchActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0042, code lost:
        if (r0.size() >= 2) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0044, code lost:
        r6.bVr.a(4, (java.util.ArrayList<java.lang.String>) null);
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
        if (this.bVr.mMode != 0) {
            if (this.bVr.mMode == 3) {
                this.bVr.bUo.setVisibility(8);
                SquareSearchActivity squareSearchActivity = this.bVr;
                scrollView2 = this.bVr.bUW;
                squareSearchActivity.R(scrollView2);
                this.bVr.mNoDataView.setVisibility(0);
                this.bVr.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.text_no_search_record));
                z = this.bVr.avq;
                if (!z) {
                    RequestSearchPersonHistoryWriteMessage requestSearchPersonHistoryWriteMessage = new RequestSearchPersonHistoryWriteMessage();
                    requestSearchPersonHistoryWriteMessage.setClear(true);
                    this.bVr.sendMessage(requestSearchPersonHistoryWriteMessage);
                    this.bVr.avq = true;
                    return;
                }
                return;
            }
            SquareSearchActivity squareSearchActivity2 = this.bVr;
            scrollView = this.bVr.bUW;
            squareSearchActivity2.R(scrollView);
            this.bVr.bUo.setVisibility(8);
            this.bVr.mNoDataView.setVisibility(0);
            this.bVr.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.text_no_search_record));
            com.baidu.tieba.tbadkCore.util.m.axv();
            return;
        }
        com.baidu.adp.lib.g.k.hh().c(new aj(this));
        list = this.bVr.bTX;
        if (list != null) {
            list4 = this.bVr.bTX;
        }
        list2 = this.bVr.bUx;
        if (list2 != null) {
            list3 = this.bVr.bUx;
        }
        SquareSearchActivity squareSearchActivity3 = this.bVr;
        scrollView3 = this.bVr.bUW;
        squareSearchActivity3.R(scrollView3);
        SquareSearchActivity squareSearchActivity4 = this.bVr;
        searchPageFocusBar = this.bVr.bUX;
        squareSearchActivity4.R(searchPageFocusBar);
        this.bVr.bUo.setVisibility(8);
        this.bVr.mNoDataView.setVisibility(0);
        this.bVr.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.text_no_search_record));
    }
}
