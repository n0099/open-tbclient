package com.baidu.tieba.mainentrance;

import android.widget.ScrollView;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.t;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements a.b {
    final /* synthetic */ SquareSearchActivity cMQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(SquareSearchActivity squareSearchActivity) {
        this.cMQ = squareSearchActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0042, code lost:
        if (r0.size() >= 2) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0044, code lost:
        r6.cMQ.a(4, (java.util.ArrayList<java.lang.String>) null);
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
        if (this.cMQ.mMode != 0) {
            if (this.cMQ.mMode == 3) {
                this.cMQ.cLN.setVisibility(8);
                SquareSearchActivity squareSearchActivity = this.cMQ;
                scrollView2 = this.cMQ.cMv;
                squareSearchActivity.aI(scrollView2);
                this.cMQ.mNoDataView.setVisibility(0);
                this.cMQ.mNoDataView.setTextOption(NoDataViewFactory.d.cO(t.j.text_no_search_record));
                z = this.cMQ.avp;
                if (!z) {
                    RequestSearchPersonHistoryWriteMessage requestSearchPersonHistoryWriteMessage = new RequestSearchPersonHistoryWriteMessage();
                    requestSearchPersonHistoryWriteMessage.setClear(true);
                    this.cMQ.sendMessage(requestSearchPersonHistoryWriteMessage);
                    this.cMQ.avp = true;
                    return;
                }
                return;
            }
            SquareSearchActivity squareSearchActivity2 = this.cMQ;
            scrollView = this.cMQ.cMv;
            squareSearchActivity2.aI(scrollView);
            this.cMQ.cLN.setVisibility(8);
            this.cMQ.mNoDataView.setVisibility(0);
            this.cMQ.mNoDataView.setTextOption(NoDataViewFactory.d.cO(t.j.text_no_search_record));
            com.baidu.tieba.tbadkCore.util.m.aUU();
            return;
        }
        com.baidu.adp.lib.h.k.dM().c(new ak(this));
        list = this.cMQ.cLA;
        if (list != null) {
            list4 = this.cMQ.cLA;
        }
        list2 = this.cMQ.cLW;
        if (list2 != null) {
            list3 = this.cMQ.cLW;
        }
        SquareSearchActivity squareSearchActivity3 = this.cMQ;
        scrollView3 = this.cMQ.cMv;
        squareSearchActivity3.aI(scrollView3);
        SquareSearchActivity squareSearchActivity4 = this.cMQ;
        searchPageFocusBar = this.cMQ.cMw;
        squareSearchActivity4.aI(searchPageFocusBar);
        this.cMQ.cLN.setVisibility(8);
        this.cMQ.mNoDataView.setVisibility(0);
        this.cMQ.mNoDataView.setTextOption(NoDataViewFactory.d.cO(t.j.text_no_search_record));
    }
}
