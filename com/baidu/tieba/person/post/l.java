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
    final /* synthetic */ k dhb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.dhb = kVar;
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
        if (this.dhb.isAdded()) {
            progressBar = this.dhb.mProgressBar;
            progressBar.setVisibility(8);
            bdListView = this.dhb.dgR;
            bdListView.nr();
            if (personPostModel != null) {
                if (k.br(personPostModel.post_list) == 0) {
                    z2 = this.dhb.dgY;
                    if (z2) {
                    }
                }
                if (k.br(personPostModel.post_list) == 0) {
                    this.dhb.mNoDataView.setVisibility(0);
                    bdListView4 = this.dhb.dgR;
                    bdListView4.setVisibility(0);
                } else {
                    this.dhb.mNoDataView.setVisibility(8);
                    bdListView3 = this.dhb.dgR;
                    bdListView3.setVisibility(0);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.k.showToast(this.dhb.getActivity(), personPostModel.getErrorString());
                }
                int br = k.br(personPostModel.post_list);
                if (br < 20) {
                    if (!com.baidu.adp.lib.util.i.iZ() || br <= 0) {
                        view = this.dhb.dgV;
                        view.setVisibility(8);
                    } else {
                        this.dhb.dgW = false;
                        pbListView2 = this.dhb.dgU;
                        pbListView2.setText(this.dhb.getResources().getString(t.j.person_post_reply_no_more));
                        view2 = this.dhb.dgV;
                        view2.setVisibility(0);
                    }
                }
                pbListView = this.dhb.dgU;
                pbListView.xc();
                if (z) {
                    if (k.br(personPostModel.post_list) < 20) {
                        this.dhb.dgW = false;
                    } else {
                        this.dhb.dgW = true;
                    }
                    this.dhb.dgX = 0;
                    this.dhb.dgY = false;
                    return;
                }
                return;
            }
            this.dhb.mNoDataView.setVisibility(0);
            bdListView2 = this.dhb.dgR;
            bdListView2.setVisibility(0);
        }
    }
}
