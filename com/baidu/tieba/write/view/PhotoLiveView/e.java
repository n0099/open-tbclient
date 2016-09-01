package com.baidu.tieba.write.view.PhotoLiveView;

import android.view.View;
import com.baidu.tieba.write.view.PhotoLiveView.a;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    private final /* synthetic */ int VV;
    final /* synthetic */ a gcE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, int i) {
        this.gcE = aVar;
        this.VV = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0082a interfaceC0082a;
        a.InterfaceC0082a interfaceC0082a2;
        interfaceC0082a = this.gcE.gcD;
        if (interfaceC0082a != null) {
            interfaceC0082a2 = this.gcE.gcD;
            interfaceC0082a2.te(this.VV);
        }
    }
}
