package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.forumdetail.ForumDetailActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ac f2500a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar) {
        this.f2500a = acVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        String str;
        activity = this.f2500a.r;
        str = this.f2500a.t;
        ForumDetailActivity.a(activity, str, ForumDetailActivity.FromType.FRS);
    }
}
