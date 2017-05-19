package com.baidu.tieba.write.view.PhotoLiveView;

import android.view.View;
import com.baidu.tieba.write.view.PhotoLiveView.a;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    private final /* synthetic */ int aak;
    final /* synthetic */ a fPT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, int i) {
        this.fPT = aVar;
        this.aak = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0084a interfaceC0084a;
        a.InterfaceC0084a interfaceC0084a2;
        interfaceC0084a = this.fPT.fPS;
        if (interfaceC0084a != null) {
            interfaceC0084a2 = this.fPT.fPS;
            interfaceC0084a2.sY(this.aak);
        }
    }
}
