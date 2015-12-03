package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.n;
import com.baidu.tieba.person.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements PersonPostModel.a {
    final /* synthetic */ j cQY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.cQY = jVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003a, code lost:
        if (com.baidu.adp.lib.util.StringUtils.isNull(r6.getErrorString()) != false) goto L36;
     */
    @Override // com.baidu.tieba.person.PersonPostModel.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PersonPostModel personPostModel, boolean z) {
        ProgressBar progressBar;
        BdListView bdListView;
        BdListView bdListView2;
        BdListView bdListView3;
        PbListView pbListView;
        View view;
        PbListView pbListView2;
        View view2;
        BdListView bdListView4;
        boolean z2;
        if (this.cQY.isAdded()) {
            progressBar = this.cQY.mProgressBar;
            progressBar.setVisibility(8);
            bdListView = this.cQY.cQO;
            bdListView.completePullRefresh();
            if (personPostModel != null) {
                if (j.bq(personPostModel.post_list) == 0) {
                    z2 = this.cQY.cQV;
                    if (z2) {
                    }
                }
                if (j.bq(personPostModel.post_list) == 0) {
                    this.cQY.mNoDataView.setVisibility(0);
                    bdListView4 = this.cQY.cQO;
                    bdListView4.setVisibility(0);
                } else {
                    this.cQY.mNoDataView.setVisibility(8);
                    bdListView3 = this.cQY.cQO;
                    bdListView3.setVisibility(0);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.k.showToast(this.cQY.getActivity(), personPostModel.getErrorString());
                }
                int bq = j.bq(personPostModel.post_list);
                if (bq < 20) {
                    if (!com.baidu.adp.lib.util.i.iP() || bq <= 0) {
                        view = this.cQY.cQS;
                        view.setVisibility(8);
                    } else {
                        this.cQY.cQT = false;
                        pbListView2 = this.cQY.cQR;
                        pbListView2.setText(this.cQY.getResources().getString(n.i.person_post_reply_no_more));
                        view2 = this.cQY.cQS;
                        view2.setVisibility(0);
                    }
                }
                pbListView = this.cQY.cQR;
                pbListView.wf();
                if (z) {
                    if (j.bq(personPostModel.post_list) < 20) {
                        this.cQY.cQT = false;
                    } else {
                        this.cQY.cQT = true;
                    }
                    this.cQY.cQU = 0;
                    this.cQY.cQV = false;
                    return;
                }
                return;
            }
            this.cQY.mNoDataView.setVisibility(0);
            bdListView2 = this.cQY.cQO;
            bdListView2.setVisibility(0);
        }
    }
}
