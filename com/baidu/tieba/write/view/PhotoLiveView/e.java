package com.baidu.tieba.write.view.PhotoLiveView;

import android.view.View;
import com.baidu.tieba.write.view.PhotoLiveView.a;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    private final /* synthetic */ int WS;
    final /* synthetic */ a eKn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, int i) {
        this.eKn = aVar;
        this.WS = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0089a interfaceC0089a;
        a.InterfaceC0089a interfaceC0089a2;
        interfaceC0089a = this.eKn.eKm;
        if (interfaceC0089a != null) {
            interfaceC0089a2 = this.eKn.eKm;
            interfaceC0089a2.qE(this.WS);
        }
    }
}
