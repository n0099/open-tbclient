package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.flist.ForumListActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsHeaderView f2602a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsHeaderView frsHeaderView) {
        this.f2602a = frsHeaderView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        String str;
        activity = this.f2602a.D;
        str = this.f2602a.J;
        ForumListActivity.a(activity, str, "2", SocialConstants.TRUE);
    }
}
