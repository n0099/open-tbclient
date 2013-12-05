package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.forumdetail.ForumDetailActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ab f2652a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar) {
        this.f2652a = abVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        String str;
        activity = this.f2652a.D;
        str = this.f2652a.F;
        ForumDetailActivity.a(activity, str, ForumDetailActivity.FromType.FRS);
    }
}
