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
    final /* synthetic */ j crQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.crQ = jVar;
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
        if (this.crQ.isAdded()) {
            progressBar = this.crQ.mProgressBar;
            progressBar.setVisibility(8);
            bdListView = this.crQ.crG;
            bdListView.completePullRefresh();
            if (personPostModel != null) {
                if (j.ba(personPostModel.post_list) == 0) {
                    z2 = this.crQ.crN;
                    if (z2) {
                    }
                }
                if (j.ba(personPostModel.post_list) == 0) {
                    this.crQ.mNoDataView.setVisibility(0);
                    bdListView4 = this.crQ.crG;
                    bdListView4.setVisibility(0);
                } else {
                    this.crQ.mNoDataView.setVisibility(8);
                    bdListView3 = this.crQ.crG;
                    bdListView3.setVisibility(0);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.k.showToast(this.crQ.getActivity(), personPostModel.getErrorString());
                }
                int ba = j.ba(personPostModel.post_list);
                if (ba < 20) {
                    if (!com.baidu.adp.lib.util.i.iM() || ba <= 0) {
                        view = this.crQ.crK;
                        view.setVisibility(8);
                    } else {
                        this.crQ.crL = false;
                        pbListView2 = this.crQ.crJ;
                        pbListView2.setText(this.crQ.getResources().getString(i.h.person_post_reply_no_more));
                        view2 = this.crQ.crK;
                        view2.setVisibility(0);
                    }
                }
                pbListView = this.crQ.crJ;
                pbListView.vy();
                if (z) {
                    if (j.ba(personPostModel.post_list) < 20) {
                        this.crQ.crL = false;
                    } else {
                        this.crQ.crL = true;
                    }
                    this.crQ.crM = 0;
                    this.crQ.crN = false;
                    return;
                }
                return;
            }
            this.crQ.mNoDataView.setVisibility(0);
            bdListView2 = this.crQ.crG;
            bdListView2.setVisibility(0);
        }
    }
}
