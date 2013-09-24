package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.flist.ForumListActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsHeaderView f2012a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(FrsHeaderView frsHeaderView) {
        this.f2012a = frsHeaderView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        String str;
        activity = this.f2012a.s;
        str = this.f2012a.y;
        ForumListActivity.a(activity, str, "2", "1");
    }
}
