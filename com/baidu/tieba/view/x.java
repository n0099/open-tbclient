package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.forumdetail.ForumDetailActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsHeaderView f2601a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FrsHeaderView frsHeaderView) {
        this.f2601a = frsHeaderView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        String str;
        activity = this.f2601a.D;
        str = this.f2601a.F;
        ForumDetailActivity.a(activity, str, ForumDetailActivity.FromType.FRS);
    }
}
