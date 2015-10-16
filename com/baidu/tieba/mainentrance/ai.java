package com.baidu.tieba.mainentrance;

import android.widget.ScrollView;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.i;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements a.b {
    final /* synthetic */ SquareSearchActivity bVC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(SquareSearchActivity squareSearchActivity) {
        this.bVC = squareSearchActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0042, code lost:
        if (r0.size() >= 2) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0044, code lost:
        r6.bVC.a(4, (java.util.ArrayList<java.lang.String>) null);
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
        if (this.bVC.mMode != 0) {
            if (this.bVC.mMode == 3) {
                this.bVC.bUz.setVisibility(8);
                SquareSearchActivity squareSearchActivity = this.bVC;
                scrollView2 = this.bVC.bVh;
                squareSearchActivity.R(scrollView2);
                this.bVC.mNoDataView.setVisibility(0);
                this.bVC.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.text_no_search_record));
                z = this.bVC.avr;
                if (!z) {
                    RequestSearchPersonHistoryWriteMessage requestSearchPersonHistoryWriteMessage = new RequestSearchPersonHistoryWriteMessage();
                    requestSearchPersonHistoryWriteMessage.setClear(true);
                    this.bVC.sendMessage(requestSearchPersonHistoryWriteMessage);
                    this.bVC.avr = true;
                    return;
                }
                return;
            }
            SquareSearchActivity squareSearchActivity2 = this.bVC;
            scrollView = this.bVC.bVh;
            squareSearchActivity2.R(scrollView);
            this.bVC.bUz.setVisibility(8);
            this.bVC.mNoDataView.setVisibility(0);
            this.bVC.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.text_no_search_record));
            com.baidu.tieba.tbadkCore.util.m.axF();
            return;
        }
        com.baidu.adp.lib.g.k.hh().c(new aj(this));
        list = this.bVC.bUi;
        if (list != null) {
            list4 = this.bVC.bUi;
        }
        list2 = this.bVC.bUI;
        if (list2 != null) {
            list3 = this.bVC.bUI;
        }
        SquareSearchActivity squareSearchActivity3 = this.bVC;
        scrollView3 = this.bVC.bVh;
        squareSearchActivity3.R(scrollView3);
        SquareSearchActivity squareSearchActivity4 = this.bVC;
        searchPageFocusBar = this.bVC.bVi;
        squareSearchActivity4.R(searchPageFocusBar);
        this.bVC.bUz.setVisibility(8);
        this.bVC.mNoDataView.setVisibility(0);
        this.bVC.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.text_no_search_record));
    }
}
