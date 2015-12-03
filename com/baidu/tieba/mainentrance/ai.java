package com.baidu.tieba.mainentrance;

import android.widget.ScrollView;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.n;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements a.b {
    final /* synthetic */ SquareSearchActivity cmr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(SquareSearchActivity squareSearchActivity) {
        this.cmr = squareSearchActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0042, code lost:
        if (r0.size() >= 2) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0044, code lost:
        r6.cmr.a(4, (java.util.ArrayList<java.lang.String>) null);
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
        if (this.cmr.mMode != 0) {
            if (this.cmr.mMode == 3) {
                this.cmr.clm.setVisibility(8);
                SquareSearchActivity squareSearchActivity = this.cmr;
                scrollView2 = this.cmr.clV;
                squareSearchActivity.X(scrollView2);
                this.cmr.mNoDataView.setVisibility(0);
                this.cmr.mNoDataView.setTextOption(NoDataViewFactory.d.cS(n.i.text_no_search_record));
                z = this.cmr.awj;
                if (!z) {
                    RequestSearchPersonHistoryWriteMessage requestSearchPersonHistoryWriteMessage = new RequestSearchPersonHistoryWriteMessage();
                    requestSearchPersonHistoryWriteMessage.setClear(true);
                    this.cmr.sendMessage(requestSearchPersonHistoryWriteMessage);
                    this.cmr.awj = true;
                    return;
                }
                return;
            }
            SquareSearchActivity squareSearchActivity2 = this.cmr;
            scrollView = this.cmr.clV;
            squareSearchActivity2.X(scrollView);
            this.cmr.clm.setVisibility(8);
            this.cmr.mNoDataView.setVisibility(0);
            this.cmr.mNoDataView.setTextOption(NoDataViewFactory.d.cS(n.i.text_no_search_record));
            com.baidu.tieba.tbadkCore.util.m.aEa();
            return;
        }
        com.baidu.adp.lib.h.k.hk().c(new aj(this));
        list = this.cmr.ckW;
        if (list != null) {
            list4 = this.cmr.ckW;
        }
        list2 = this.cmr.clv;
        if (list2 != null) {
            list3 = this.cmr.clv;
        }
        SquareSearchActivity squareSearchActivity3 = this.cmr;
        scrollView3 = this.cmr.clV;
        squareSearchActivity3.X(scrollView3);
        SquareSearchActivity squareSearchActivity4 = this.cmr;
        searchPageFocusBar = this.cmr.clW;
        squareSearchActivity4.X(searchPageFocusBar);
        this.cmr.clm.setVisibility(8);
        this.cmr.mNoDataView.setVisibility(0);
        this.cmr.mNoDataView.setTextOption(NoDataViewFactory.d.cS(n.i.text_no_search_record));
    }
}
