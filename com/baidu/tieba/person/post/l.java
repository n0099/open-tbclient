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
public class l implements f {
    final /* synthetic */ k a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.a = kVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005e, code lost:
        if (r7.getErrorString().equals("") != false) goto L40;
     */
    @Override // com.baidu.tieba.person.post.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PersonPostModel personPostModel, boolean z) {
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
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                textView7 = this.a.g;
                textView7.setTextColor(this.a.getResources().getColor(com.baidu.tieba.o.person_post_header_uname_1));
            } else {
                textView = this.a.g;
                textView.setTextColor(this.a.getResources().getColor(com.baidu.tieba.o.person_post_header_uname));
            }
            if (personPostModel != null) {
                if (k.a(personPostModel.post_list) == 0) {
                    z2 = this.a.m;
                    if (z2) {
                        if (personPostModel.getErrorString() != null) {
                            if (personPostModel.getErrorString() != null) {
                            }
                        }
                    }
                }
                if (personPostModel.getErrorString() != null && !personPostModel.getErrorString().equals("")) {
                    if (k.a(personPostModel.post_list) == 0) {
                        bdListView3 = this.a.c;
                        textView6 = this.a.g;
                        bdListView3.setEmptyView(textView6);
                    }
                    if (personPostModel.getErrorCode() != 0) {
                        com.baidu.adp.lib.util.h.a((Context) this.a.getActivity(), personPostModel.getErrorString());
                    }
                }
                textView5 = this.a.g;
                textView5.setVisibility(8);
                if (k.a(personPostModel.post_list) < 20) {
                    if (!UtilHelper.isNetOk()) {
                        view = this.a.j;
                        view.setVisibility(8);
                    } else {
                        this.a.k = false;
                        pbListView2 = this.a.i;
                        pbListView2.a(this.a.getResources().getString(com.baidu.tieba.u.person_post_reply_no_more));
                        view2 = this.a.j;
                        view2.setVisibility(0);
                    }
                }
                pbListView = this.a.i;
                pbListView.e();
                bdListView2 = this.a.c;
                bdListView2.c();
                if (z) {
                    this.a.k = true;
                    this.a.l = 0;
                    this.a.m = false;
                    return;
                }
                return;
            }
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                textView4 = this.a.g;
                textView4.setTextColor(this.a.getResources().getColor(com.baidu.tieba.o.person_post_header_uname_1));
            } else {
                textView2 = this.a.g;
                textView2.setTextColor(this.a.getResources().getColor(com.baidu.tieba.o.person_post_header_uname));
            }
            bdListView = this.a.c;
            textView3 = this.a.g;
            bdListView.setEmptyView(textView3);
        }
    }
}
