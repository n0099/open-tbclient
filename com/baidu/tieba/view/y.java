package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.flist.ForumListActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsHeaderView f2585a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsHeaderView frsHeaderView) {
        this.f2585a = frsHeaderView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        String str;
        activity = this.f2585a.E;
        str = this.f2585a.K;
        ForumListActivity.a(activity, str, "2", SocialConstants.TRUE);
    }
}
