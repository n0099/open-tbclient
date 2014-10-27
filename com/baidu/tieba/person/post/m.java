package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.ProgressBar;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements g {
    final /* synthetic */ l bDU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.bDU = lVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0038, code lost:
        if (com.baidu.adp.lib.util.StringUtils.isNull(r5.getErrorString()) != false) goto L33;
     */
    @Override // com.baidu.tieba.person.post.g
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
        if (this.bDU.isAdded()) {
            progressBar = this.bDU.mProgressBar;
            progressBar.setVisibility(8);
            bdListView = this.bDU.bDK;
            bdListView.hN();
            if (personPostModel != null) {
                if (l.ai(personPostModel.post_list) == 0) {
                    z2 = this.bDU.bDR;
                    if (z2) {
                    }
                }
                if (!StringUtils.isNull(personPostModel.getErrorString())) {
                    if (l.ai(personPostModel.post_list) == 0) {
                        this.bDU.ahO.setVisibility(0);
                        bdListView4 = this.bDU.bDK;
                        bdListView4.setVisibility(0);
                    } else {
                        this.bDU.ahO.setVisibility(8);
                        bdListView3 = this.bDU.bDK;
                        bdListView3.setVisibility(0);
                    }
                    if (personPostModel.getErrorCode() != 0) {
                        com.baidu.adp.lib.util.m.showToast(this.bDU.getActivity(), personPostModel.getErrorString());
                    }
                }
                if (l.ai(personPostModel.post_list) < 20) {
                    if (!com.baidu.adp.lib.util.j.fh()) {
                        view = this.bDU.bDO;
                        view.setVisibility(8);
                    } else {
                        this.bDU.bDP = false;
                        pbListView2 = this.bDU.bDN;
                        pbListView2.setText(this.bDU.getResources().getString(com.baidu.tieba.y.person_post_reply_no_more));
                        view2 = this.bDU.bDO;
                        view2.setVisibility(0);
                    }
                }
                pbListView = this.bDU.bDN;
                pbListView.XT();
                if (z) {
                    this.bDU.bDP = true;
                    this.bDU.bDQ = 0;
                    this.bDU.bDR = false;
                    return;
                }
                return;
            }
            this.bDU.ahO.setVisibility(0);
            bdListView2 = this.bDU.bDK;
            bdListView2.setVisibility(0);
        }
    }
}
