package com.baidu.tieba.pb.pb.a;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d eep;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.eep = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        context = this.eep.mContext;
        if (!bg.aN(context)) {
            return;
        }
        this.eep.a(view, 300L);
    }
}
