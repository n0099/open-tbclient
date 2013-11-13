package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.forumdetail.ForumDetailActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aa f2554a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(aa aaVar) {
        this.f2554a = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        String str;
        activity = this.f2554a.D;
        str = this.f2554a.F;
        ForumDetailActivity.a(activity, str, ForumDetailActivity.FromType.FRS);
    }
}
