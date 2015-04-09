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
    final /* synthetic */ k bRR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.bRR = kVar;
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
        if (this.bRR.isAdded()) {
            progressBar = this.bRR.mProgressBar;
            progressBar.setVisibility(8);
            bdListView = this.bRR.bRI;
            bdListView.mW();
            if (personPostModel != null) {
                if (k.aU(personPostModel.post_list) == 0) {
                    z2 = this.bRR.bRO;
                    if (z2) {
                    }
                }
                if (!StringUtils.isNull(personPostModel.getErrorString())) {
                    if (k.aU(personPostModel.post_list) == 0) {
                        this.bRR.mNoDataView.setVisibility(0);
                        bdListView4 = this.bRR.bRI;
                        bdListView4.setVisibility(0);
                    } else {
                        this.bRR.mNoDataView.setVisibility(8);
                        bdListView3 = this.bRR.bRI;
                        bdListView3.setVisibility(0);
                    }
                    if (personPostModel.getErrorCode() != 0) {
                        com.baidu.adp.lib.util.n.showToast(this.bRR.getActivity(), personPostModel.getErrorString());
                    }
                }
                if (k.aU(personPostModel.post_list) < 20) {
                    if (!com.baidu.adp.lib.util.k.iH()) {
                        view = this.bRR.bRM;
                        view.setVisibility(8);
                    } else {
                        this.bRR.bRN = false;
                        pbListView2 = this.bRR.bRL;
                        pbListView2.setText(this.bRR.getResources().getString(com.baidu.tieba.y.person_post_reply_no_more));
                        view2 = this.bRR.bRM;
                        view2.setVisibility(0);
                    }
                }
                pbListView = this.bRR.bRL;
                pbListView.tO();
                if (z) {
                    this.bRR.bRN = true;
                    this.bRR.mLastCount = 0;
                    this.bRR.bRO = false;
                    return;
                }
                return;
            }
            this.bRR.mNoDataView.setVisibility(0);
            bdListView2 = this.bRR.bRI;
            bdListView2.setVisibility(0);
        }
    }
}
