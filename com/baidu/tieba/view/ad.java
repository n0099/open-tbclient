package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.flist.ForumListActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aa f2555a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(aa aaVar) {
        this.f2555a = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        String str;
        activity = this.f2555a.D;
        str = this.f2555a.ad;
        ForumListActivity.a(activity, str, "2", SocialConstants.TRUE);
    }
}
