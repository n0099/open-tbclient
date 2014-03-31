package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.data.ai;
import com.baidu.tieba.model.am;
/* loaded from: classes.dex */
final class y implements View.OnClickListener {
    final /* synthetic */ PostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PostActivity postActivity) {
        this.a = postActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        am amVar;
        am amVar2;
        am amVar3;
        amVar = this.a.l;
        if (amVar != null) {
            amVar2 = this.a.l;
            if (amVar2.a() != null) {
                amVar3 = this.a.l;
                ai aiVar = amVar3.a().e().get(0);
                if (aiVar != null) {
                    com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001003, new com.baidu.tbadk.core.b.ag(this.a, aiVar.g().getUserId(), aiVar.g().getUserName())));
                }
            }
        }
    }
}
