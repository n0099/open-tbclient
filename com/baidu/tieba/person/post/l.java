package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements PersonPostModel.a {
    final /* synthetic */ k dBB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.dBB = kVar;
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
        if (this.dBB.isAdded()) {
            progressBar = this.dBB.mProgressBar;
            progressBar.setVisibility(8);
            bdListView = this.dBB.dBr;
            bdListView.nj();
            if (personPostModel != null) {
                if (k.bN(personPostModel.post_list) == 0) {
                    z2 = this.dBB.dBy;
                    if (z2) {
                    }
                }
                if (k.bN(personPostModel.post_list) == 0) {
                    this.dBB.mNoDataView.setVisibility(0);
                    bdListView4 = this.dBB.dBr;
                    bdListView4.setVisibility(0);
                } else {
                    this.dBB.mNoDataView.setVisibility(8);
                    bdListView3 = this.dBB.dBr;
                    bdListView3.setVisibility(0);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.k.showToast(this.dBB.getActivity(), personPostModel.getErrorString());
                }
                int bN = k.bN(personPostModel.post_list);
                if (bN < 20) {
                    if (!com.baidu.adp.lib.util.i.jf() || bN <= 0) {
                        view = this.dBB.dBv;
                        view.setVisibility(8);
                    } else {
                        this.dBB.dBw = false;
                        pbListView2 = this.dBB.dBu;
                        pbListView2.setText(this.dBB.getResources().getString(t.j.person_post_reply_no_more));
                        view2 = this.dBB.dBv;
                        view2.setVisibility(0);
                    }
                }
                pbListView = this.dBB.dBu;
                pbListView.xv();
                if (z) {
                    if (k.bN(personPostModel.post_list) < 20) {
                        this.dBB.dBw = false;
                    } else {
                        this.dBB.dBw = true;
                    }
                    this.dBB.dBx = 0;
                    this.dBB.dBy = false;
                    return;
                }
                return;
            }
            this.dBB.mNoDataView.setVisibility(0);
            bdListView2 = this.dBB.dBr;
            bdListView2.setVisibility(0);
        }
    }
}
