package com.baidu.tieba.write.view.PhotoLiveView;

import android.view.View;
import com.baidu.tieba.write.view.PhotoLiveView.a;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    private final /* synthetic */ int aaP;
    final /* synthetic */ a fRO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, int i) {
        this.fRO = aVar;
        this.aaP = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0077a interfaceC0077a;
        a.InterfaceC0077a interfaceC0077a2;
        interfaceC0077a = this.fRO.fRN;
        if (interfaceC0077a != null) {
            interfaceC0077a2 = this.fRO.fRN;
            interfaceC0077a2.tb(this.aaP);
        }
    }
}
