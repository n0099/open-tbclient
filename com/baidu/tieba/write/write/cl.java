package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cl implements View.OnClickListener {
    final /* synthetic */ ck gmI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(ck ckVar) {
        this.gmI = ckVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && view.getId() != 0) {
            if (view.getId() == w.h.icon_invoke_link) {
                this.gmI.buP();
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c12169"));
            }
            if (view.getId() == w.h.url_edit_back_view) {
                this.gmI.buO();
            }
        }
    }
}
