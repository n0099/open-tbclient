package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.flist.ForumListActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements View.OnClickListener {
    final /* synthetic */ ar a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(ar arVar) {
        this.a = arVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        String str;
        activity = this.a.y;
        str = this.a.T;
        ForumListActivity.a(activity, str, "2", SocialConstants.TRUE);
    }
}
