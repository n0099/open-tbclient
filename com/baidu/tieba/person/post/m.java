package com.baidu.tieba.person.post;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements g {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.a = lVar;
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
        if (this.a.isAdded()) {
            progressBar = this.a.f;
            progressBar.setVisibility(8);
            bdListView = this.a.d;
            bdListView.d();
            if (personPostModel != null) {
                if (l.a(personPostModel.post_list) == 0) {
                    z2 = this.a.m;
                    if (z2) {
                    }
                }
                if (!StringUtils.isNull(personPostModel.getErrorString())) {
                    if (l.a(personPostModel.post_list) == 0) {
                        this.a.b.b(0);
                        bdListView4 = this.a.d;
                        bdListView4.setVisibility(0);
                    } else {
                        this.a.b.b(8);
                        bdListView3 = this.a.d;
                        bdListView3.setVisibility(0);
                    }
                    if (personPostModel.getErrorCode() != 0) {
                        com.baidu.adp.lib.util.j.a((Context) this.a.getActivity(), personPostModel.getErrorString());
                    }
                }
                if (l.a(personPostModel.post_list) < 20) {
                    if (!UtilHelper.isNetOk()) {
                        view = this.a.j;
                        view.setVisibility(8);
                    } else {
                        this.a.k = false;
                        pbListView2 = this.a.i;
                        pbListView2.a(this.a.getResources().getString(com.baidu.tieba.y.person_post_reply_no_more));
                        view2 = this.a.j;
                        view2.setVisibility(0);
                    }
                }
                pbListView = this.a.i;
                pbListView.e();
                if (z) {
                    this.a.k = true;
                    this.a.l = 0;
                    this.a.m = false;
                    return;
                }
                return;
            }
            this.a.b.b(0);
            bdListView2 = this.a.d;
            bdListView2.setVisibility(0);
        }
    }
}
