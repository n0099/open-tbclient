package com.baidu.tieba.pb.pb.a;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.util.bh;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d ejP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.ejP = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        context = this.ejP.mContext;
        if (!bh.aN(context) || com.baidu.tieba.pb.e.hS(this.ejP.alE)) {
            return;
        }
        this.ejP.a(view, 300L);
    }
}
