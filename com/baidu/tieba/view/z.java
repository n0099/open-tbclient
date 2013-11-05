package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.flist.ForumListActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsHeaderView f2547a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(FrsHeaderView frsHeaderView) {
        this.f2547a = frsHeaderView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        String str;
        activity = this.f2547a.s;
        str = this.f2547a.y;
        ForumListActivity.a(activity, str, "2", SocialConstants.TRUE);
    }
}
