package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.ProgressBar;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.bq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements bq {
    final /* synthetic */ j bJs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.bJs = jVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0038, code lost:
        if (com.baidu.adp.lib.util.StringUtils.isNull(r5.getErrorString()) != false) goto L33;
     */
    @Override // com.baidu.tieba.person.bq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PersonPostModel personPostModel, boolean z) {
        ProgressBar progressBar;
        BdListView bdListView;
        BdListView bdListView2;
        PbListView pbListView;
        View view;
        PbListView pbListView2;
        View view2;
        BdListView bdListView3;
        BdListView bdListView4;
        boolean z2;
        if (this.bJs.isAdded()) {
            progressBar = this.bJs.mProgressBar;
            progressBar.setVisibility(8);
            bdListView = this.bJs.bJj;
            bdListView.jI();
            if (personPostModel != null) {
                if (j.aH(personPostModel.post_list) == 0) {
                    z2 = this.bJs.bJp;
                    if (z2) {
                    }
                }
                if (!StringUtils.isNull(personPostModel.getErrorString())) {
                    if (j.aH(personPostModel.post_list) == 0) {
                        this.bJs.mNoDataView.setVisibility(0);
                        bdListView4 = this.bJs.bJj;
                        bdListView4.setVisibility(0);
                    } else {
                        this.bJs.mNoDataView.setVisibility(8);
                        bdListView3 = this.bJs.bJj;
                        bdListView3.setVisibility(0);
                    }
                    if (personPostModel.getErrorCode() != 0) {
                        com.baidu.adp.lib.util.l.showToast(this.bJs.getActivity(), personPostModel.getErrorString());
                    }
                }
                if (j.aH(personPostModel.post_list) < 20) {
                    if (!com.baidu.adp.lib.util.i.ff()) {
                        view = this.bJs.bJn;
                        view.setVisibility(8);
                    } else {
                        this.bJs.bJo = false;
                        pbListView2 = this.bJs.bJm;
                        pbListView2.setText(this.bJs.getResources().getString(com.baidu.tieba.z.person_post_reply_no_more));
                        view2 = this.bJs.bJn;
                        view2.setVisibility(0);
                    }
                }
                pbListView = this.bJs.bJm;
                pbListView.qK();
                if (z) {
                    this.bJs.bJo = true;
                    this.bJs.mLastCount = 0;
                    this.bJs.bJp = false;
                    return;
                }
                return;
            }
            this.bJs.mNoDataView.setVisibility(0);
            bdListView2 = this.bJs.bJj;
            bdListView2.setVisibility(0);
        }
    }
}
