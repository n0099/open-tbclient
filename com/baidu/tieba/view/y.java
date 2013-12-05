package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.forumdetail.ForumDetailActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsHeaderView f2702a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsHeaderView frsHeaderView) {
        this.f2702a = frsHeaderView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        String str;
        activity = this.f2702a.E;
        str = this.f2702a.G;
        ForumDetailActivity.a(activity, str, ForumDetailActivity.FromType.FRS);
    }
}
