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
    final /* synthetic */ k dEJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.dEJ = kVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003d, code lost:
        if (com.baidu.adp.lib.util.StringUtils.isNull(r8.getErrorString()) != false) goto L36;
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
        if (this.dEJ.isAdded()) {
            progressBar = this.dEJ.mProgressBar;
            progressBar.setVisibility(8);
            bdListView = this.dEJ.dEz;
            bdListView.k(2000L);
            if (personPostModel != null) {
                if (k.bP(personPostModel.post_list) == 0) {
                    z2 = this.dEJ.dEG;
                    if (z2) {
                    }
                }
                if (k.bP(personPostModel.post_list) == 0) {
                    bdListView4 = this.dEJ.dEz;
                    bdListView4.setVisibility(8);
                    this.dEJ.hl(true);
                } else {
                    bdListView3 = this.dEJ.dEz;
                    bdListView3.setVisibility(0);
                    this.dEJ.hl(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.k.showToast(this.dEJ.getActivity(), personPostModel.getErrorString());
                }
                int bP = k.bP(personPostModel.post_list);
                if (bP < 20) {
                    if (!com.baidu.adp.lib.util.i.fq() || bP <= 0) {
                        view = this.dEJ.dED;
                        view.setVisibility(8);
                    } else {
                        this.dEJ.dEE = false;
                        pbListView2 = this.dEJ.dEC;
                        pbListView2.setText(this.dEJ.getResources().getString(t.j.person_post_reply_no_more));
                        view2 = this.dEJ.dED;
                        view2.setVisibility(0);
                    }
                }
                pbListView = this.dEJ.dEC;
                pbListView.vi();
                if (z) {
                    if (k.bP(personPostModel.post_list) < 20) {
                        this.dEJ.dEE = false;
                    } else {
                        this.dEJ.dEE = true;
                    }
                    this.dEJ.dEF = 0;
                    this.dEJ.dEG = false;
                    return;
                }
                return;
            }
            bdListView2 = this.dEJ.dEz;
            bdListView2.setVisibility(0);
            this.dEJ.hl(true);
        }
    }
}
