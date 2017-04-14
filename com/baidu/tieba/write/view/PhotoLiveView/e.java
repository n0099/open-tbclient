package com.baidu.tieba.write.view.PhotoLiveView;

import android.view.View;
import com.baidu.tieba.write.view.PhotoLiveView.a;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    private final /* synthetic */ int aaO;
    final /* synthetic */ a fPs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, int i) {
        this.fPs = aVar;
        this.aaO = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0077a interfaceC0077a;
        a.InterfaceC0077a interfaceC0077a2;
        interfaceC0077a = this.fPs.fPr;
        if (interfaceC0077a != null) {
            interfaceC0077a2 = this.fPs.fPr;
            interfaceC0077a2.sV(this.aaO);
        }
    }
}
