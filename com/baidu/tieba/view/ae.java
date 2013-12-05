package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.flist.ForumListActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ab f2653a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ab abVar) {
        this.f2653a = abVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        String str;
        activity = this.f2653a.D;
        str = this.f2653a.ad;
        ForumListActivity.a(activity, str, "2", SocialConstants.TRUE);
    }
}
