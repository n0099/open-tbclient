package com.baidu.tieba.mainentrance;

import android.widget.ScrollView;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.t;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements a.b {
    final /* synthetic */ SquareSearchActivity cLU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(SquareSearchActivity squareSearchActivity) {
        this.cLU = squareSearchActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0042, code lost:
        if (r0.size() >= 2) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0044, code lost:
        r6.cLU.a(4, (java.util.ArrayList<java.lang.String>) null);
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
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
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
        if (this.cLU.mMode != 0) {
            if (this.cLU.mMode == 3) {
                this.cLU.cKR.setVisibility(8);
                SquareSearchActivity squareSearchActivity = this.cLU;
                scrollView2 = this.cLU.cLz;
                squareSearchActivity.aE(scrollView2);
                this.cLU.mNoDataView.setVisibility(0);
                this.cLU.mNoDataView.setTextOption(NoDataViewFactory.d.dg(t.j.text_no_search_record));
                z = this.cLU.azn;
                if (!z) {
                    RequestSearchPersonHistoryWriteMessage requestSearchPersonHistoryWriteMessage = new RequestSearchPersonHistoryWriteMessage();
                    requestSearchPersonHistoryWriteMessage.setClear(true);
                    this.cLU.sendMessage(requestSearchPersonHistoryWriteMessage);
                    this.cLU.azn = true;
                    return;
                }
                return;
            }
            SquareSearchActivity squareSearchActivity2 = this.cLU;
            scrollView = this.cLU.cLz;
            squareSearchActivity2.aE(scrollView);
            this.cLU.cKR.setVisibility(8);
            this.cLU.mNoDataView.setVisibility(0);
            this.cLU.mNoDataView.setTextOption(NoDataViewFactory.d.dg(t.j.text_no_search_record));
            com.baidu.tieba.tbadkCore.util.m.aUt();
            return;
        }
        com.baidu.adp.lib.h.k.hy().c(new ak(this));
        list = this.cLU.cKE;
        if (list != null) {
            list4 = this.cLU.cKE;
        }
        list2 = this.cLU.cLa;
        if (list2 != null) {
            list3 = this.cLU.cLa;
        }
        SquareSearchActivity squareSearchActivity3 = this.cLU;
        scrollView3 = this.cLU.cLz;
        squareSearchActivity3.aE(scrollView3);
        SquareSearchActivity squareSearchActivity4 = this.cLU;
        searchPageFocusBar = this.cLU.cLA;
        squareSearchActivity4.aE(searchPageFocusBar);
        this.cLU.cKR.setVisibility(8);
        this.cLU.mNoDataView.setVisibility(0);
        this.cLU.mNoDataView.setTextOption(NoDataViewFactory.d.dg(t.j.text_no_search_record));
    }
}
