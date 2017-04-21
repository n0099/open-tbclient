package com.baidu.tieba.pb.pb.a;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d ejm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.ejm = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        context = this.ejm.mContext;
        if (!bg.aK(context)) {
            return;
        }
        this.ejm.a(view, 300L);
    }
}
