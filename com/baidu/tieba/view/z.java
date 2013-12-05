package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.flist.ForumListActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsHeaderView f2703a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(FrsHeaderView frsHeaderView) {
        this.f2703a = frsHeaderView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        String str;
        activity = this.f2703a.E;
        str = this.f2703a.K;
        ForumListActivity.a(activity, str, "2", SocialConstants.TRUE);
    }
}
