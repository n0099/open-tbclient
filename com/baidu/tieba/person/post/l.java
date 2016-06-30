package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements PersonPostModel.a {
    final /* synthetic */ k enD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.enD = kVar;
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
        if (this.enD.isAdded()) {
            progressBar = this.enD.mProgressBar;
            progressBar.setVisibility(8);
            bdListView = this.enD.ent;
            bdListView.k(2000L);
            if (personPostModel != null) {
                if (k.cn(personPostModel.post_list) == 0) {
                    z2 = this.enD.enA;
                    if (z2) {
                    }
                }
                if (k.cn(personPostModel.post_list) == 0) {
                    bdListView4 = this.enD.ent;
                    bdListView4.setVisibility(8);
                    this.enD.ig(true);
                } else {
                    bdListView3 = this.enD.ent;
                    bdListView3.setVisibility(0);
                    this.enD.ig(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.k.showToast(this.enD.getActivity(), personPostModel.getErrorString());
                }
                int cn = k.cn(personPostModel.post_list);
                if (cn < 20) {
                    if (!com.baidu.adp.lib.util.i.fr() || cn <= 0) {
                        view = this.enD.enx;
                        view.setVisibility(8);
                    } else {
                        this.enD.eny = false;
                        pbListView2 = this.enD.enw;
                        pbListView2.setText(this.enD.getResources().getString(u.j.person_post_reply_no_more));
                        view2 = this.enD.enx;
                        view2.setVisibility(0);
                    }
                }
                pbListView = this.enD.enw;
                pbListView.vi();
                if (z) {
                    if (k.cn(personPostModel.post_list) < 20) {
                        this.enD.eny = false;
                    } else {
                        this.enD.eny = true;
                    }
                    this.enD.enz = 0;
                    this.enD.enA = false;
                    return;
                }
                return;
            }
            bdListView2 = this.enD.ent;
            bdListView2.setVisibility(0);
            this.enD.ig(true);
        }
    }
}
