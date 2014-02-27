package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.forumdetail.ForumDetailActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class at implements View.OnClickListener {
    final /* synthetic */ ar a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(ar arVar) {
        this.a = arVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Activity activity;
        String str;
        activity = this.a.y;
        str = this.a.A;
        ForumDetailActivity.a(activity, str, ForumDetailActivity.FromType.FRS);
    }
}
