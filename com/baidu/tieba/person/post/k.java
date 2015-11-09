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
    final /* synthetic */ j ctm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.ctm = jVar;
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
        if (this.ctm.isAdded()) {
            progressBar = this.ctm.mProgressBar;
            progressBar.setVisibility(8);
            bdListView = this.ctm.ctc;
            bdListView.completePullRefresh();
            if (personPostModel != null) {
                if (j.be(personPostModel.post_list) == 0) {
                    z2 = this.ctm.ctj;
                    if (z2) {
                    }
                }
                if (j.be(personPostModel.post_list) == 0) {
                    this.ctm.mNoDataView.setVisibility(0);
                    bdListView4 = this.ctm.ctc;
                    bdListView4.setVisibility(0);
                } else {
                    this.ctm.mNoDataView.setVisibility(8);
                    bdListView3 = this.ctm.ctc;
                    bdListView3.setVisibility(0);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.k.showToast(this.ctm.getActivity(), personPostModel.getErrorString());
                }
                int be = j.be(personPostModel.post_list);
                if (be < 20) {
                    if (!com.baidu.adp.lib.util.i.iN() || be <= 0) {
                        view = this.ctm.ctg;
                        view.setVisibility(8);
                    } else {
                        this.ctm.cth = false;
                        pbListView2 = this.ctm.ctf;
                        pbListView2.setText(this.ctm.getResources().getString(i.h.person_post_reply_no_more));
                        view2 = this.ctm.ctg;
                        view2.setVisibility(0);
                    }
                }
                pbListView = this.ctm.ctf;
                pbListView.vz();
                if (z) {
                    if (j.be(personPostModel.post_list) < 20) {
                        this.ctm.cth = false;
                    } else {
                        this.ctm.cth = true;
                    }
                    this.ctm.cti = 0;
                    this.ctm.ctj = false;
                    return;
                }
                return;
            }
            this.ctm.mNoDataView.setVisibility(0);
            bdListView2 = this.ctm.ctc;
            bdListView2.setVisibility(0);
        }
    }
}
