package com.baidu.tieba.write.view.PhotoLiveView;

import android.view.View;
import com.baidu.tieba.write.view.PhotoLiveView.a;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    private final /* synthetic */ int aay;
    final /* synthetic */ a fNJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, int i) {
        this.fNJ = aVar;
        this.aay = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0078a interfaceC0078a;
        a.InterfaceC0078a interfaceC0078a2;
        interfaceC0078a = this.fNJ.fNI;
        if (interfaceC0078a != null) {
            interfaceC0078a2 = this.fNJ.fNI;
            interfaceC0078a2.sX(this.aay);
        }
    }
}
