package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.ProgressBar;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements g {
    final /* synthetic */ l bEi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.bEi = lVar;
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
        if (this.bEi.isAdded()) {
            progressBar = this.bEi.mProgressBar;
            progressBar.setVisibility(8);
            bdListView = this.bEi.bDY;
            bdListView.hN();
            if (personPostModel != null) {
                if (l.ai(personPostModel.post_list) == 0) {
                    z2 = this.bEi.bEf;
                    if (z2) {
                    }
                }
                if (!StringUtils.isNull(personPostModel.getErrorString())) {
                    if (l.ai(personPostModel.post_list) == 0) {
                        this.bEi.ahX.setVisibility(0);
                        bdListView4 = this.bEi.bDY;
                        bdListView4.setVisibility(0);
                    } else {
                        this.bEi.ahX.setVisibility(8);
                        bdListView3 = this.bEi.bDY;
                        bdListView3.setVisibility(0);
                    }
                    if (personPostModel.getErrorCode() != 0) {
                        com.baidu.adp.lib.util.m.showToast(this.bEi.getActivity(), personPostModel.getErrorString());
                    }
                }
                if (l.ai(personPostModel.post_list) < 20) {
                    if (!com.baidu.adp.lib.util.j.fh()) {
                        view = this.bEi.bEc;
                        view.setVisibility(8);
                    } else {
                        this.bEi.bEd = false;
                        pbListView2 = this.bEi.bEb;
                        pbListView2.setText(this.bEi.getResources().getString(com.baidu.tieba.y.person_post_reply_no_more));
                        view2 = this.bEi.bEc;
                        view2.setVisibility(0);
                    }
                }
                pbListView = this.bEi.bEb;
                pbListView.XW();
                if (z) {
                    this.bEi.bEd = true;
                    this.bEi.bEe = 0;
                    this.bEi.bEf = false;
                    return;
                }
                return;
            }
            this.bEi.ahX.setVisibility(0);
            bdListView2 = this.bEi.bDY;
            bdListView2.setVisibility(0);
        }
    }
}
