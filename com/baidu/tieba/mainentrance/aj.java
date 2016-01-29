package com.baidu.tieba.mainentrance;

import android.widget.ScrollView;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.t;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements a.b {
    final /* synthetic */ SquareSearchActivity cwZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(SquareSearchActivity squareSearchActivity) {
        this.cwZ = squareSearchActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0042, code lost:
        if (r0.size() >= 2) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0044, code lost:
        r6.cwZ.a(4, (java.util.ArrayList<java.lang.String>) null);
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
        if (this.cwZ.mMode != 0) {
            if (this.cwZ.mMode == 3) {
                this.cwZ.cvW.setVisibility(8);
                SquareSearchActivity squareSearchActivity = this.cwZ;
                scrollView2 = this.cwZ.cwE;
                squareSearchActivity.av(scrollView2);
                this.cwZ.mNoDataView.setVisibility(0);
                this.cwZ.mNoDataView.setTextOption(NoDataViewFactory.d.dd(t.j.text_no_search_record));
                z = this.cwZ.ayG;
                if (!z) {
                    RequestSearchPersonHistoryWriteMessage requestSearchPersonHistoryWriteMessage = new RequestSearchPersonHistoryWriteMessage();
                    requestSearchPersonHistoryWriteMessage.setClear(true);
                    this.cwZ.sendMessage(requestSearchPersonHistoryWriteMessage);
                    this.cwZ.ayG = true;
                    return;
                }
                return;
            }
            SquareSearchActivity squareSearchActivity2 = this.cwZ;
            scrollView = this.cwZ.cwE;
            squareSearchActivity2.av(scrollView);
            this.cwZ.cvW.setVisibility(8);
            this.cwZ.mNoDataView.setVisibility(0);
            this.cwZ.mNoDataView.setTextOption(NoDataViewFactory.d.dd(t.j.text_no_search_record));
            com.baidu.tieba.tbadkCore.util.m.aNs();
            return;
        }
        com.baidu.adp.lib.h.k.hs().c(new ak(this));
        list = this.cwZ.cvJ;
        if (list != null) {
            list4 = this.cwZ.cvJ;
        }
        list2 = this.cwZ.cwf;
        if (list2 != null) {
            list3 = this.cwZ.cwf;
        }
        SquareSearchActivity squareSearchActivity3 = this.cwZ;
        scrollView3 = this.cwZ.cwE;
        squareSearchActivity3.av(scrollView3);
        SquareSearchActivity squareSearchActivity4 = this.cwZ;
        searchPageFocusBar = this.cwZ.cwF;
        squareSearchActivity4.av(searchPageFocusBar);
        this.cwZ.cvW.setVisibility(8);
        this.cwZ.mNoDataView.setVisibility(0);
        this.cwZ.mNoDataView.setTextOption(NoDataViewFactory.d.dd(t.j.text_no_search_record));
    }
}
