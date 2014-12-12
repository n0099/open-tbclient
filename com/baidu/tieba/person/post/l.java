package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.ProgressBar;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.br;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements br {
    final /* synthetic */ k bHG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.bHG = kVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0038, code lost:
        if (com.baidu.adp.lib.util.StringUtils.isNull(r5.getErrorString()) != false) goto L33;
     */
    @Override // com.baidu.tieba.person.br
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
        if (this.bHG.isAdded()) {
            progressBar = this.bHG.mProgressBar;
            progressBar.setVisibility(8);
            bdListView = this.bHG.bHx;
            bdListView.jJ();
            if (personPostModel != null) {
                if (k.aE(personPostModel.post_list) == 0) {
                    z2 = this.bHG.bHD;
                    if (z2) {
                    }
                }
                if (!StringUtils.isNull(personPostModel.getErrorString())) {
                    if (k.aE(personPostModel.post_list) == 0) {
                        this.bHG.mNoDataView.setVisibility(0);
                        bdListView4 = this.bHG.bHx;
                        bdListView4.setVisibility(0);
                    } else {
                        this.bHG.mNoDataView.setVisibility(8);
                        bdListView3 = this.bHG.bHx;
                        bdListView3.setVisibility(0);
                    }
                    if (personPostModel.getErrorCode() != 0) {
                        com.baidu.adp.lib.util.l.showToast(this.bHG.getActivity(), personPostModel.getErrorString());
                    }
                }
                if (k.aE(personPostModel.post_list) < 20) {
                    if (!com.baidu.adp.lib.util.i.fg()) {
                        view = this.bHG.bHB;
                        view.setVisibility(8);
                    } else {
                        this.bHG.bHC = false;
                        pbListView2 = this.bHG.bHA;
                        pbListView2.setText(this.bHG.getResources().getString(com.baidu.tieba.z.person_post_reply_no_more));
                        view2 = this.bHG.bHB;
                        view2.setVisibility(0);
                    }
                }
                pbListView = this.bHG.bHA;
                pbListView.qz();
                if (z) {
                    this.bHG.bHC = true;
                    this.bHG.mLastCount = 0;
                    this.bHG.bHD = false;
                    return;
                }
                return;
            }
            this.bHG.mNoDataView.setVisibility(0);
            bdListView2 = this.bHG.bHx;
            bdListView2.setVisibility(0);
        }
    }
}
