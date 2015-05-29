package com.baidu.tieba.im.widget.invite2GroupView;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    private final /* synthetic */ TbPageContext NC;
    final /* synthetic */ d brz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, TbPageContext tbPageContext) {
        this.brz = dVar;
        this.NC = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Invite2GroupView invite2GroupView;
        invite2GroupView = this.brz.bry;
        if (invite2GroupView.getContext() instanceof Activity) {
            this.NC.showToast(t.has_recent_join);
        }
    }
}
