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
    final /* synthetic */ j cVA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.cVA = jVar;
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
        if (this.cVA.isAdded()) {
            progressBar = this.cVA.mProgressBar;
            progressBar.setVisibility(8);
            bdListView = this.cVA.cVq;
            bdListView.completePullRefresh();
            if (personPostModel != null) {
                if (j.bn(personPostModel.post_list) == 0) {
                    z2 = this.cVA.cVx;
                    if (z2) {
                    }
                }
                if (j.bn(personPostModel.post_list) == 0) {
                    this.cVA.mNoDataView.setVisibility(0);
                    bdListView4 = this.cVA.cVq;
                    bdListView4.setVisibility(0);
                } else {
                    this.cVA.mNoDataView.setVisibility(8);
                    bdListView3 = this.cVA.cVq;
                    bdListView3.setVisibility(0);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.k.showToast(this.cVA.getActivity(), personPostModel.getErrorString());
                }
                int bn = j.bn(personPostModel.post_list);
                if (bn < 20) {
                    if (!com.baidu.adp.lib.util.i.iQ() || bn <= 0) {
                        view = this.cVA.cVu;
                        view.setVisibility(8);
                    } else {
                        this.cVA.cVv = false;
                        pbListView2 = this.cVA.cVt;
                        pbListView2.setText(this.cVA.getResources().getString(n.j.person_post_reply_no_more));
                        view2 = this.cVA.cVu;
                        view2.setVisibility(0);
                    }
                }
                pbListView = this.cVA.cVt;
                pbListView.vP();
                if (z) {
                    if (j.bn(personPostModel.post_list) < 20) {
                        this.cVA.cVv = false;
                    } else {
                        this.cVA.cVv = true;
                    }
                    this.cVA.cVw = 0;
                    this.cVA.cVx = false;
                    return;
                }
                return;
            }
            this.cVA.mNoDataView.setVisibility(0);
            bdListView2 = this.cVA.cVq;
            bdListView2.setVisibility(0);
        }
    }
}
