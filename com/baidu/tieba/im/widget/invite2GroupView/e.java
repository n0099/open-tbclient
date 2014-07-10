package com.baidu.tieba.im.widget.invite2GroupView;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.a = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Invite2GroupView invite2GroupView;
        Invite2GroupView invite2GroupView2;
        invite2GroupView = this.a.a;
        if (invite2GroupView.getContext() instanceof Activity) {
            invite2GroupView2 = this.a.a;
            ((BaseActivity) invite2GroupView2.getContext()).showToast(y.has_recent_join);
        }
    }
}
