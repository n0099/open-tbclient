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
    final /* synthetic */ j bJr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.bJr = jVar;
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
        if (this.bJr.isAdded()) {
            progressBar = this.bJr.mProgressBar;
            progressBar.setVisibility(8);
            bdListView = this.bJr.bJi;
            bdListView.jB();
            if (personPostModel != null) {
                if (j.aH(personPostModel.post_list) == 0) {
                    z2 = this.bJr.bJo;
                    if (z2) {
                    }
                }
                if (!StringUtils.isNull(personPostModel.getErrorString())) {
                    if (j.aH(personPostModel.post_list) == 0) {
                        this.bJr.mNoDataView.setVisibility(0);
                        bdListView4 = this.bJr.bJi;
                        bdListView4.setVisibility(0);
                    } else {
                        this.bJr.mNoDataView.setVisibility(8);
                        bdListView3 = this.bJr.bJi;
                        bdListView3.setVisibility(0);
                    }
                    if (personPostModel.getErrorCode() != 0) {
                        com.baidu.adp.lib.util.l.showToast(this.bJr.getActivity(), personPostModel.getErrorString());
                    }
                }
                if (j.aH(personPostModel.post_list) < 20) {
                    if (!com.baidu.adp.lib.util.i.ff()) {
                        view = this.bJr.bJm;
                        view.setVisibility(8);
                    } else {
                        this.bJr.bJn = false;
                        pbListView2 = this.bJr.bJl;
                        pbListView2.setText(this.bJr.getResources().getString(com.baidu.tieba.z.person_post_reply_no_more));
                        view2 = this.bJr.bJm;
                        view2.setVisibility(0);
                    }
                }
                pbListView = this.bJr.bJl;
                pbListView.qE();
                if (z) {
                    this.bJr.bJn = true;
                    this.bJr.mLastCount = 0;
                    this.bJr.bJo = false;
                    return;
                }
                return;
            }
            this.bJr.mNoDataView.setVisibility(0);
            bdListView2 = this.bJr.bJi;
            bdListView2.setVisibility(0);
        }
    }
}
