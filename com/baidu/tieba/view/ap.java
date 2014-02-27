package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.forumdetail.ForumDetailActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ap implements View.OnClickListener {
    final /* synthetic */ FrsHeaderView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(FrsHeaderView frsHeaderView) {
        this.a = frsHeaderView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Activity activity;
        String str;
        activity = this.a.A;
        str = this.a.C;
        ForumDetailActivity.a(activity, str, ForumDetailActivity.FromType.FRS);
    }
}
