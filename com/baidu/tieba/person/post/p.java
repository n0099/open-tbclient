package com.baidu.tieba.person.post;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.PbListView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements m {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonReplyFragment f2278a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PersonReplyFragment personReplyFragment) {
        this.f2278a = personReplyFragment;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
        if (r8.getErrorString().equals("") != false) goto L38;
     */
    @Override // com.baidu.tieba.person.post.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PersonPostReplyModel personPostReplyModel, boolean z) {
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
        if (this.f2278a.n()) {
            progressBar = this.f2278a.d;
            progressBar.setVisibility(8);
            if (TiebaApplication.g().ap() == 1) {
                textView7 = this.f2278a.f;
                textView7.setTextColor(this.f2278a.j().getColor(R.color.person_post_header_uname_1));
            } else {
                textView = this.f2278a.f;
                textView.setTextColor(this.f2278a.j().getColor(R.color.person_post_header_uname));
            }
            if (personPostReplyModel != null) {
                if (PersonPostReplyModel.getRealPostCount(personPostReplyModel.post_list) == 0) {
                    z2 = this.f2278a.aa;
                    if (z2) {
                        if (personPostReplyModel.getErrorString() != null) {
                            if (personPostReplyModel.getErrorString() != null) {
                            }
                        }
                    }
                }
                if (personPostReplyModel.getErrorString() != null && !personPostReplyModel.getErrorString().equals("")) {
                    if (PersonPostReplyModel.getRealPostCount(personPostReplyModel.post_list) == 0) {
                        bdListView3 = this.f2278a.b;
                        textView6 = this.f2278a.f;
                        bdListView3.setEmptyView(textView6);
                    }
                    UtilHelper.a((Context) this.f2278a.i(), personPostReplyModel.getErrorString());
                }
                textView5 = this.f2278a.f;
                textView5.setVisibility(8);
                if (PersonPostReplyModel.getRealPostCount(personPostReplyModel.post_list) < 20) {
                    if (UtilHelper.b()) {
                        this.f2278a.Y = false;
                        pbListView2 = this.f2278a.h;
                        pbListView2.a(this.f2278a.j().getString(R.string.person_post_reply_no_more));
                        view2 = this.f2278a.i;
                        view2.setVisibility(0);
                    } else {
                        view = this.f2278a.i;
                        view.setVisibility(8);
                    }
                }
                pbListView = this.f2278a.h;
                pbListView.d();
                bdListView2 = this.f2278a.b;
                bdListView2.a();
                if (z) {
                    this.f2278a.Y = true;
                    this.f2278a.Z = 0;
                    this.f2278a.aa = false;
                    return;
                }
                return;
            }
            if (TiebaApplication.g().ap() == 1) {
                textView4 = this.f2278a.f;
                textView4.setTextColor(this.f2278a.j().getColor(R.color.person_post_header_uname_1));
            } else {
                textView2 = this.f2278a.f;
                textView2.setTextColor(this.f2278a.j().getColor(R.color.person_post_header_uname));
            }
            bdListView = this.f2278a.b;
            textView3 = this.f2278a.f;
            bdListView.setEmptyView(textView3);
        }
    }
}
