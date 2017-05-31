package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cn implements View.OnClickListener {
    final /* synthetic */ cm gbK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(cm cmVar) {
        this.gbK = cmVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && view.getId() != 0) {
            if (view.getId() == w.h.icon_invoke_link) {
                this.gbK.bqp();
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c12169"));
            }
            if (view.getId() == w.h.url_edit_back_view) {
                this.gbK.bqo();
            }
        }
    }
}
