package com.baidu.tieba.im.widget.invite2GroupView;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    private final /* synthetic */ TbPageContext SL;
    final /* synthetic */ d ccL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, TbPageContext tbPageContext) {
        this.ccL = dVar;
        this.SL = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Invite2GroupView invite2GroupView;
        invite2GroupView = this.ccL.ccK;
        if (invite2GroupView.getContext() instanceof Activity) {
            this.SL.showToast(n.j.has_recent_join);
        }
    }
}
