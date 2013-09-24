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
public class o implements m {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonReplyFragment f1722a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PersonReplyFragment personReplyFragment) {
        this.f1722a = personReplyFragment;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
        if (r6.getErrorString().equals("") != false) goto L33;
     */
    @Override // com.baidu.tieba.person.post.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PersonPostReplyModel personPostReplyModel, boolean z) {
        ProgressBar progressBar;
        TextView textView;
        BdListView bdListView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        PbListView pbListView;
        BdListView bdListView2;
        View view;
        PbListView pbListView2;
        View view2;
        boolean z2;
        if (this.f1722a.k()) {
            progressBar = this.f1722a.d;
            progressBar.setVisibility(8);
            if (personPostReplyModel != null) {
                if (PersonPostReplyModel.getRealPostCount(personPostReplyModel.post_list) == 0) {
                    z2 = this.f1722a.aa;
                    if (z2) {
                        if (personPostReplyModel.getErrorString() != null) {
                            if (personPostReplyModel.getErrorString() != null) {
                            }
                        }
                    }
                }
                if (personPostReplyModel.getErrorString() != null && !personPostReplyModel.getErrorString().equals("")) {
                    UtilHelper.a((Context) this.f1722a.h(), personPostReplyModel.getErrorString());
                }
                textView4 = this.f1722a.f;
                textView4.setVisibility(8);
                if (PersonPostReplyModel.getRealPostCount(personPostReplyModel.post_list) < 20) {
                    if (!UtilHelper.b()) {
                        view = this.f1722a.i;
                        view.setVisibility(8);
                    } else {
                        this.f1722a.Y = false;
                        pbListView2 = this.f1722a.h;
                        pbListView2.a(this.f1722a.i().getString(R.string.person_post_reply_no_more));
                        view2 = this.f1722a.i;
                        view2.setVisibility(0);
                    }
                }
                pbListView = this.f1722a.h;
                pbListView.d();
                bdListView2 = this.f1722a.b;
                bdListView2.a();
                if (z) {
                    this.f1722a.Y = true;
                    this.f1722a.Z = 0;
                    this.f1722a.aa = false;
                    return;
                }
                return;
            }
            if (TiebaApplication.g().ap() == 1) {
                textView3 = this.f1722a.f;
                textView3.setTextColor(this.f1722a.i().getColor(R.color.person_post_header_uname_1));
            } else {
                textView = this.f1722a.f;
                textView.setTextColor(this.f1722a.i().getColor(R.color.person_post_header_uname));
            }
            bdListView = this.f1722a.b;
            textView2 = this.f1722a.f;
            bdListView.setEmptyView(textView2);
        }
    }
}
