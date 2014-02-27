package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tieba.data.aq;
import com.baidu.tieba.model.bn;
import com.baidu.tieba.person.cm;
/* loaded from: classes.dex */
final class y implements View.OnClickListener {
    final /* synthetic */ PostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PostActivity postActivity) {
        this.a = postActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        bn bnVar;
        bn bnVar2;
        bn bnVar3;
        bnVar = this.a.l;
        if (bnVar != null) {
            bnVar2 = this.a.l;
            if (bnVar2.a() != null) {
                bnVar3 = this.a.l;
                aq aqVar = bnVar3.a().e().get(0);
                if (aqVar != null) {
                    cm.a(this.a, aqVar.g().getUserId(), aqVar.g().getUserName());
                }
            }
        }
    }
}
