package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.i;
import com.baidu.tieba.person.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements PersonPostModel.a {
    final /* synthetic */ i clg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.clg = iVar;
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
        if (this.clg.isAdded()) {
            progressBar = this.clg.mProgressBar;
            progressBar.setVisibility(8);
            bdListView = this.clg.ckW;
            bdListView.completePullRefresh();
            if (personPostModel != null) {
                if (i.aX(personPostModel.post_list) == 0) {
                    z2 = this.clg.cld;
                    if (z2) {
                    }
                }
                if (i.aX(personPostModel.post_list) == 0) {
                    this.clg.mNoDataView.setVisibility(0);
                    bdListView4 = this.clg.ckW;
                    bdListView4.setVisibility(0);
                } else {
                    this.clg.mNoDataView.setVisibility(8);
                    bdListView3 = this.clg.ckW;
                    bdListView3.setVisibility(0);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.k.showToast(this.clg.getActivity(), personPostModel.getErrorString());
                }
                int aX = i.aX(personPostModel.post_list);
                if (aX < 20) {
                    if (!com.baidu.adp.lib.util.i.iO() || aX <= 0) {
                        view = this.clg.cla;
                        view.setVisibility(8);
                    } else {
                        this.clg.clb = false;
                        pbListView2 = this.clg.ckZ;
                        pbListView2.setText(this.clg.getResources().getString(i.C0057i.person_post_reply_no_more));
                        view2 = this.clg.cla;
                        view2.setVisibility(0);
                    }
                }
                pbListView = this.clg.ckZ;
                pbListView.vB();
                if (z) {
                    if (i.aX(personPostModel.post_list) < 20) {
                        this.clg.clb = false;
                    } else {
                        this.clg.clb = true;
                    }
                    this.clg.clc = 0;
                    this.clg.cld = false;
                    return;
                }
                return;
            }
            this.clg.mNoDataView.setVisibility(0);
            bdListView2 = this.clg.ckW;
            bdListView2.setVisibility(0);
        }
    }
}
