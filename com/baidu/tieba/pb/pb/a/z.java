package com.baidu.tieba.pb.pb.a;

import android.view.View;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.bl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ r dej;
    private final /* synthetic */ PraiseData deq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(r rVar, PraiseData praiseData) {
        this.dej = rVar;
        this.deq = praiseData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((this.deq == null || this.deq.getIsLike() != 1) && this.dej.dfw != null && bl.ad(this.dej.dfw.getPageContext().getPageActivity())) {
            this.dej.dfw.awh();
        }
    }
}
