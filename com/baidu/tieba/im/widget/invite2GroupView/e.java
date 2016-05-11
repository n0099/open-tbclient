package com.baidu.tieba.im.widget.invite2GroupView;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    private final /* synthetic */ TbPageContext Kq;
    final /* synthetic */ d csM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, TbPageContext tbPageContext) {
        this.csM = dVar;
        this.Kq = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Invite2GroupView invite2GroupView;
        invite2GroupView = this.csM.csL;
        if (invite2GroupView.getContext() instanceof Activity) {
            this.Kq.showToast(t.j.has_recent_join);
        }
    }
}
