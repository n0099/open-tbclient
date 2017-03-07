package com.baidu.tieba.pb.pb.a;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d eiQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.eiQ = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        context = this.eiQ.mContext;
        if (!bg.aI(context)) {
            return;
        }
        this.eiQ.a(view, 300L);
    }
}
