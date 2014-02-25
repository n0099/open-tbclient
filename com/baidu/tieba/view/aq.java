package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.flist.ForumListActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements View.OnClickListener {
    final /* synthetic */ FrsHeaderView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(FrsHeaderView frsHeaderView) {
        this.a = frsHeaderView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        String str;
        activity = this.a.A;
        str = this.a.G;
        ForumListActivity.a(activity, str, "2", SocialConstants.TRUE);
    }
}
