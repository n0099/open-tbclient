package com.baidu.tieba.mainentrance;

import android.widget.ScrollView;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.n;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements a.b {
    final /* synthetic */ SquareSearchActivity cqu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(SquareSearchActivity squareSearchActivity) {
        this.cqu = squareSearchActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0042, code lost:
        if (r0.size() >= 2) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0044, code lost:
        r6.cqu.a(4, (java.util.ArrayList<java.lang.String>) null);
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
        if (this.cqu.mMode != 0) {
            if (this.cqu.mMode == 3) {
                this.cqu.cpq.setVisibility(8);
                SquareSearchActivity squareSearchActivity = this.cqu;
                scrollView2 = this.cqu.cpZ;
                squareSearchActivity.ac(scrollView2);
                this.cqu.mNoDataView.setVisibility(0);
                this.cqu.mNoDataView.setTextOption(NoDataViewFactory.d.cM(n.j.text_no_search_record));
                z = this.cqu.axN;
                if (!z) {
                    RequestSearchPersonHistoryWriteMessage requestSearchPersonHistoryWriteMessage = new RequestSearchPersonHistoryWriteMessage();
                    requestSearchPersonHistoryWriteMessage.setClear(true);
                    this.cqu.sendMessage(requestSearchPersonHistoryWriteMessage);
                    this.cqu.axN = true;
                    return;
                }
                return;
            }
            SquareSearchActivity squareSearchActivity2 = this.cqu;
            scrollView = this.cqu.cpZ;
            squareSearchActivity2.ac(scrollView);
            this.cqu.cpq.setVisibility(8);
            this.cqu.mNoDataView.setVisibility(0);
            this.cqu.mNoDataView.setTextOption(NoDataViewFactory.d.cM(n.j.text_no_search_record));
            com.baidu.tieba.tbadkCore.util.m.aGn();
            return;
        }
        com.baidu.adp.lib.h.k.hk().c(new aj(this));
        list = this.cqu.cpa;
        if (list != null) {
            list4 = this.cqu.cpa;
        }
        list2 = this.cqu.cpz;
        if (list2 != null) {
            list3 = this.cqu.cpz;
        }
        SquareSearchActivity squareSearchActivity3 = this.cqu;
        scrollView3 = this.cqu.cpZ;
        squareSearchActivity3.ac(scrollView3);
        SquareSearchActivity squareSearchActivity4 = this.cqu;
        searchPageFocusBar = this.cqu.cqa;
        squareSearchActivity4.ac(searchPageFocusBar);
        this.cqu.cpq.setVisibility(8);
        this.cqu.mNoDataView.setVisibility(0);
        this.cqu.mNoDataView.setTextOption(NoDataViewFactory.d.cM(n.j.text_no_search_record));
    }
}
