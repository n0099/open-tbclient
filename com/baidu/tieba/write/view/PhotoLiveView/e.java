package com.baidu.tieba.write.view.PhotoLiveView;

import android.view.View;
import com.baidu.tieba.write.view.PhotoLiveView.a;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    private final /* synthetic */ int aak;
    final /* synthetic */ a giP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, int i) {
        this.giP = aVar;
        this.aak = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0089a interfaceC0089a;
        a.InterfaceC0089a interfaceC0089a2;
        interfaceC0089a = this.giP.giO;
        if (interfaceC0089a != null) {
            interfaceC0089a2 = this.giP.giO;
            interfaceC0089a2.tP(this.aak);
        }
    }
}
