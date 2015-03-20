package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.ProgressBar;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.bo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements bo {
    final /* synthetic */ k bRB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.bRB = kVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0038, code lost:
        if (com.baidu.adp.lib.util.StringUtils.isNull(r5.getErrorString()) != false) goto L33;
     */
    @Override // com.baidu.tieba.person.bo
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
        if (this.bRB.isAdded()) {
            progressBar = this.bRB.mProgressBar;
            progressBar.setVisibility(8);
            bdListView = this.bRB.bRs;
            bdListView.mW();
            if (personPostModel != null) {
                if (k.aR(personPostModel.post_list) == 0) {
                    z2 = this.bRB.bRy;
                    if (z2) {
                    }
                }
                if (!StringUtils.isNull(personPostModel.getErrorString())) {
                    if (k.aR(personPostModel.post_list) == 0) {
                        this.bRB.mNoDataView.setVisibility(0);
                        bdListView4 = this.bRB.bRs;
                        bdListView4.setVisibility(0);
                    } else {
                        this.bRB.mNoDataView.setVisibility(8);
                        bdListView3 = this.bRB.bRs;
                        bdListView3.setVisibility(0);
                    }
                    if (personPostModel.getErrorCode() != 0) {
                        com.baidu.adp.lib.util.n.showToast(this.bRB.getActivity(), personPostModel.getErrorString());
                    }
                }
                if (k.aR(personPostModel.post_list) < 20) {
                    if (!com.baidu.adp.lib.util.k.iH()) {
                        view = this.bRB.bRw;
                        view.setVisibility(8);
                    } else {
                        this.bRB.bRx = false;
                        pbListView2 = this.bRB.bRv;
                        pbListView2.setText(this.bRB.getResources().getString(com.baidu.tieba.y.person_post_reply_no_more));
                        view2 = this.bRB.bRw;
                        view2.setVisibility(0);
                    }
                }
                pbListView = this.bRB.bRv;
                pbListView.tO();
                if (z) {
                    this.bRB.bRx = true;
                    this.bRB.mLastCount = 0;
                    this.bRB.bRy = false;
                    return;
                }
                return;
            }
            this.bRB.mNoDataView.setVisibility(0);
            bdListView2 = this.bRB.bRs;
            bdListView2.setVisibility(0);
        }
    }
}
