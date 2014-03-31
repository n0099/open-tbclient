package com.baidu.tieba.person.post;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p implements m {
    final /* synthetic */ o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.a = oVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005d, code lost:
        if (r7.getErrorString().equals("") != false) goto L38;
     */
    @Override // com.baidu.tieba.person.post.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(PersonPostReplyModel personPostReplyModel, boolean z) {
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        BdListView bdListView;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        PbListView pbListView;
        BdListView bdListView2;
        View view;
        PbListView pbListView2;
        View view2;
        BdListView bdListView3;
        TextView textView6;
        boolean z2;
        TextView textView7;
        if (this.a.isAdded()) {
            progressBar = this.a.d;
            progressBar.setVisibility(8);
            if (TbadkApplication.j().l() == 1) {
                textView7 = this.a.f;
                textView7.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.person_post_header_uname_1));
            } else {
                textView = this.a.f;
                textView.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.person_post_header_uname));
            }
            if (personPostReplyModel != null) {
                if (PersonPostReplyModel.getRealPostCount(personPostReplyModel.post_list) == 0) {
                    z2 = this.a.l;
                    if (z2) {
                        if (personPostReplyModel.getErrorString() != null) {
                            if (personPostReplyModel.getErrorString() != null) {
                            }
                        }
                    }
                }
                if (personPostReplyModel.getErrorString() != null && !personPostReplyModel.getErrorString().equals("")) {
                    if (PersonPostReplyModel.getRealPostCount(personPostReplyModel.post_list) == 0) {
                        bdListView3 = this.a.b;
                        textView6 = this.a.f;
                        bdListView3.setEmptyView(textView6);
                    }
                    com.baidu.adp.lib.util.i.a((Context) this.a.getActivity(), personPostReplyModel.getErrorString());
                }
                textView5 = this.a.f;
                textView5.setVisibility(8);
                if (PersonPostReplyModel.getRealPostCount(personPostReplyModel.post_list) < 20) {
                    if (!UtilHelper.a()) {
                        view = this.a.i;
                        view.setVisibility(8);
                    } else {
                        this.a.j = false;
                        pbListView2 = this.a.h;
                        pbListView2.a(this.a.getResources().getString(com.baidu.tieba.a.k.person_post_reply_no_more));
                        view2 = this.a.i;
                        view2.setVisibility(0);
                    }
                }
                pbListView = this.a.h;
                pbListView.e();
                bdListView2 = this.a.b;
                bdListView2.b();
                if (z) {
                    this.a.j = true;
                    this.a.k = 0;
                    this.a.l = false;
                    return;
                }
                return;
            }
            if (TbadkApplication.j().l() == 1) {
                textView4 = this.a.f;
                textView4.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.person_post_header_uname_1));
            } else {
                textView2 = this.a.f;
                textView2.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.person_post_header_uname));
            }
            bdListView = this.a.b;
            textView3 = this.a.f;
            bdListView.setEmptyView(textView3);
        }
    }
}
