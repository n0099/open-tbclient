package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.flist.ForumListActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsHeaderView f1882a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FrsHeaderView frsHeaderView) {
        this.f1882a = frsHeaderView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        String str;
        activity = this.f1882a.v;
        str = this.f1882a.B;
        ForumListActivity.a(activity, str, "2", "1");
    }
}
