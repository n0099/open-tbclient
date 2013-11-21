package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.forumdetail.ForumDetailActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsHeaderView f2584a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FrsHeaderView frsHeaderView) {
        this.f2584a = frsHeaderView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        String str;
        activity = this.f2584a.E;
        str = this.f2584a.G;
        ForumDetailActivity.a(activity, str, ForumDetailActivity.FromType.FRS);
    }
}
