package com.baidu.tieba.pb.pb.a;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.util.bl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d esN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.esN = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        context = this.esN.mContext;
        if (!bl.aN(context) || com.baidu.tieba.pb.i.io(this.esN.amt)) {
            return;
        }
        this.esN.a(view, 300L);
    }
}
