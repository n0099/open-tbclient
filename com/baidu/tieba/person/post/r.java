package com.baidu.tieba.person.post;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.PbListView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r implements o {
    final /* synthetic */ q a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.a = qVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
        if (r8.getErrorString().equals("") != false) goto L38;
     */
    @Override // com.baidu.tieba.person.post.o
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
            progressBar = this.a.e;
            progressBar.setVisibility(8);
            if (TiebaApplication.g().ae() == 1) {
                textView7 = this.a.g;
                textView7.setTextColor(this.a.getResources().getColor(R.color.person_post_header_uname_1));
            } else {
                textView = this.a.g;
                textView.setTextColor(this.a.getResources().getColor(R.color.person_post_header_uname));
            }
            if (personPostReplyModel != null) {
                if (PersonPostReplyModel.getRealPostCount(personPostReplyModel.post_list) == 0) {
                    z2 = this.a.m;
                    if (z2) {
                        if (personPostReplyModel.getErrorString() != null) {
                            if (personPostReplyModel.getErrorString() != null) {
                            }
                        }
                    }
                }
                if (personPostReplyModel.getErrorString() != null && !personPostReplyModel.getErrorString().equals("")) {
                    if (PersonPostReplyModel.getRealPostCount(personPostReplyModel.post_list) == 0) {
                        bdListView3 = this.a.c;
                        textView6 = this.a.g;
                        bdListView3.setEmptyView(textView6);
                    }
                    BdUtilHelper.a((Context) this.a.getActivity(), personPostReplyModel.getErrorString());
                }
                textView5 = this.a.g;
                textView5.setVisibility(8);
                if (PersonPostReplyModel.getRealPostCount(personPostReplyModel.post_list) < 20) {
                    if (!UtilHelper.b()) {
                        view = this.a.j;
                        view.setVisibility(8);
                    } else {
                        this.a.k = false;
                        pbListView2 = this.a.i;
                        pbListView2.a(this.a.getResources().getString(R.string.person_post_reply_no_more));
                        view2 = this.a.j;
                        view2.setVisibility(0);
                    }
                }
                pbListView = this.a.i;
                pbListView.d();
                bdListView2 = this.a.c;
                bdListView2.a();
                if (z) {
                    this.a.k = true;
                    this.a.l = 0;
                    this.a.m = false;
                    return;
                }
                return;
            }
            if (TiebaApplication.g().ae() == 1) {
                textView4 = this.a.g;
                textView4.setTextColor(this.a.getResources().getColor(R.color.person_post_header_uname_1));
            } else {
                textView2 = this.a.g;
                textView2.setTextColor(this.a.getResources().getColor(R.color.person_post_header_uname));
            }
            bdListView = this.a.c;
            textView3 = this.a.g;
            bdListView.setEmptyView(textView3);
        }
    }
}
