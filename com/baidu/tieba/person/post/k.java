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
    final /* synthetic */ j cmb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.cmb = jVar;
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
        if (this.cmb.isAdded()) {
            progressBar = this.cmb.mProgressBar;
            progressBar.setVisibility(8);
            bdListView = this.cmb.clR;
            bdListView.completePullRefresh();
            if (personPostModel != null) {
                if (j.aY(personPostModel.post_list) == 0) {
                    z2 = this.cmb.clY;
                    if (z2) {
                    }
                }
                if (j.aY(personPostModel.post_list) == 0) {
                    this.cmb.mNoDataView.setVisibility(0);
                    bdListView4 = this.cmb.clR;
                    bdListView4.setVisibility(0);
                } else {
                    this.cmb.mNoDataView.setVisibility(8);
                    bdListView3 = this.cmb.clR;
                    bdListView3.setVisibility(0);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.k.showToast(this.cmb.getActivity(), personPostModel.getErrorString());
                }
                int aY = j.aY(personPostModel.post_list);
                if (aY < 20) {
                    if (!com.baidu.adp.lib.util.i.iL() || aY <= 0) {
                        view = this.cmb.clV;
                        view.setVisibility(8);
                    } else {
                        this.cmb.clW = false;
                        pbListView2 = this.cmb.clU;
                        pbListView2.setText(this.cmb.getResources().getString(i.h.person_post_reply_no_more));
                        view2 = this.cmb.clV;
                        view2.setVisibility(0);
                    }
                }
                pbListView = this.cmb.clU;
                pbListView.vG();
                if (z) {
                    if (j.aY(personPostModel.post_list) < 20) {
                        this.cmb.clW = false;
                    } else {
                        this.cmb.clW = true;
                    }
                    this.cmb.clX = 0;
                    this.cmb.clY = false;
                    return;
                }
                return;
            }
            this.cmb.mNoDataView.setVisibility(0);
            bdListView2 = this.cmb.clR;
            bdListView2.setVisibility(0);
        }
    }
}
