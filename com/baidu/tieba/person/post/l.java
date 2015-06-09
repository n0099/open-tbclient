package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.ProgressBar;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.ch;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements ch {
    final /* synthetic */ k bUz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.bUz = kVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0038, code lost:
        if (com.baidu.adp.lib.util.StringUtils.isNull(r5.getErrorString()) != false) goto L33;
     */
    @Override // com.baidu.tieba.person.ch
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
        if (this.bUz.isAdded()) {
            progressBar = this.bUz.mProgressBar;
            progressBar.setVisibility(8);
            bdListView = this.bUz.bUq;
            bdListView.completePullRefresh();
            if (personPostModel != null) {
                if (k.aT(personPostModel.post_list) == 0) {
                    z2 = this.bUz.bUw;
                    if (z2) {
                    }
                }
                if (!StringUtils.isNull(personPostModel.getErrorString())) {
                    if (k.aT(personPostModel.post_list) == 0) {
                        this.bUz.mNoDataView.setVisibility(0);
                        bdListView4 = this.bUz.bUq;
                        bdListView4.setVisibility(0);
                    } else {
                        this.bUz.mNoDataView.setVisibility(8);
                        bdListView3 = this.bUz.bUq;
                        bdListView3.setVisibility(0);
                    }
                    if (personPostModel.getErrorCode() != 0) {
                        com.baidu.adp.lib.util.n.showToast(this.bUz.getActivity(), personPostModel.getErrorString());
                    }
                }
                if (k.aT(personPostModel.post_list) < 20) {
                    if (!com.baidu.adp.lib.util.k.iX()) {
                        view = this.bUz.bUu;
                        view.setVisibility(8);
                    } else {
                        this.bUz.bUv = false;
                        pbListView2 = this.bUz.bUt;
                        pbListView2.setText(this.bUz.getResources().getString(com.baidu.tieba.t.person_post_reply_no_more));
                        view2 = this.bUz.bUu;
                        view2.setVisibility(0);
                    }
                }
                pbListView = this.bUz.bUt;
                pbListView.ux();
                if (z) {
                    this.bUz.bUv = true;
                    this.bUz.mLastCount = 0;
                    this.bUz.bUw = false;
                    return;
                }
                return;
            }
            this.bUz.mNoDataView.setVisibility(0);
            bdListView2 = this.bUz.bUq;
            bdListView2.setVisibility(0);
        }
    }
}
