package com.baidu.tieba.im.widget.invite2GroupView;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    private final /* synthetic */ TbPageContext RY;
    final /* synthetic */ d bJG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, TbPageContext tbPageContext) {
        this.bJG = dVar;
        this.RY = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Invite2GroupView invite2GroupView;
        invite2GroupView = this.bJG.bJF;
        if (invite2GroupView.getContext() instanceof Activity) {
            this.RY.showToast(i.h.has_recent_join);
        }
    }
}
