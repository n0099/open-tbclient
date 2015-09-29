package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.i;
import com.baidu.tieba.person.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements PersonPostModel.a {
    final /* synthetic */ j crF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.crF = jVar;
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
        if (this.crF.isAdded()) {
            progressBar = this.crF.mProgressBar;
            progressBar.setVisibility(8);
            bdListView = this.crF.crv;
            bdListView.completePullRefresh();
            if (personPostModel != null) {
                if (j.ba(personPostModel.post_list) == 0) {
                    z2 = this.crF.crC;
                    if (z2) {
                    }
                }
                if (j.ba(personPostModel.post_list) == 0) {
                    this.crF.mNoDataView.setVisibility(0);
                    bdListView4 = this.crF.crv;
                    bdListView4.setVisibility(0);
                } else {
                    this.crF.mNoDataView.setVisibility(8);
                    bdListView3 = this.crF.crv;
                    bdListView3.setVisibility(0);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.k.showToast(this.crF.getActivity(), personPostModel.getErrorString());
                }
                int ba = j.ba(personPostModel.post_list);
                if (ba < 20) {
                    if (!com.baidu.adp.lib.util.i.iM() || ba <= 0) {
                        view = this.crF.crz;
                        view.setVisibility(8);
                    } else {
                        this.crF.crA = false;
                        pbListView2 = this.crF.cry;
                        pbListView2.setText(this.crF.getResources().getString(i.h.person_post_reply_no_more));
                        view2 = this.crF.crz;
                        view2.setVisibility(0);
                    }
                }
                pbListView = this.crF.cry;
                pbListView.vy();
                if (z) {
                    if (j.ba(personPostModel.post_list) < 20) {
                        this.crF.crA = false;
                    } else {
                        this.crF.crA = true;
                    }
                    this.crF.crB = 0;
                    this.crF.crC = false;
                    return;
                }
                return;
            }
            this.crF.mNoDataView.setVisibility(0);
            bdListView2 = this.crF.crv;
            bdListView2.setVisibility(0);
        }
    }
}
