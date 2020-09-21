package com.baidu.ufosdk.ui;

import android.view.View;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import java.util.Map;
/* loaded from: classes21.dex */
final class ci implements View.OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ cg b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(cg cgVar, int i) {
        this.b = cgVar;
        this.a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.baidu.ufosdk.f.c.a("点击已解决！！！");
        ((Map) this.b.a.h.get(this.a)).put(UgcUBCUtils.UGC_TYPE_ASK, 2);
        new Thread(new cj(this)).start();
    }
}
