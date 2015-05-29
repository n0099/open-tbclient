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
    final /* synthetic */ k bUy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.bUy = kVar;
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
        if (this.bUy.isAdded()) {
            progressBar = this.bUy.mProgressBar;
            progressBar.setVisibility(8);
            bdListView = this.bUy.bUp;
            bdListView.completePullRefresh();
            if (personPostModel != null) {
                if (k.aT(personPostModel.post_list) == 0) {
                    z2 = this.bUy.bUv;
                    if (z2) {
                    }
                }
                if (!StringUtils.isNull(personPostModel.getErrorString())) {
                    if (k.aT(personPostModel.post_list) == 0) {
                        this.bUy.mNoDataView.setVisibility(0);
                        bdListView4 = this.bUy.bUp;
                        bdListView4.setVisibility(0);
                    } else {
                        this.bUy.mNoDataView.setVisibility(8);
                        bdListView3 = this.bUy.bUp;
                        bdListView3.setVisibility(0);
                    }
                    if (personPostModel.getErrorCode() != 0) {
                        com.baidu.adp.lib.util.n.showToast(this.bUy.getActivity(), personPostModel.getErrorString());
                    }
                }
                if (k.aT(personPostModel.post_list) < 20) {
                    if (!com.baidu.adp.lib.util.k.iX()) {
                        view = this.bUy.bUt;
                        view.setVisibility(8);
                    } else {
                        this.bUy.bUu = false;
                        pbListView2 = this.bUy.bUs;
                        pbListView2.setText(this.bUy.getResources().getString(com.baidu.tieba.t.person_post_reply_no_more));
                        view2 = this.bUy.bUt;
                        view2.setVisibility(0);
                    }
                }
                pbListView = this.bUy.bUs;
                pbListView.ux();
                if (z) {
                    this.bUy.bUu = true;
                    this.bUy.mLastCount = 0;
                    this.bUy.bUv = false;
                    return;
                }
                return;
            }
            this.bUy.mNoDataView.setVisibility(0);
            bdListView2 = this.bUy.bUp;
            bdListView2.setVisibility(0);
        }
    }
}
