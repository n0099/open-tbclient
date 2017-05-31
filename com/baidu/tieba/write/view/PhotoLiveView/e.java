package com.baidu.tieba.write.view.PhotoLiveView;

import android.view.View;
import com.baidu.tieba.write.view.PhotoLiveView.a;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    private final /* synthetic */ int aaj;
    final /* synthetic */ a fXP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, int i) {
        this.fXP = aVar;
        this.aaj = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0087a interfaceC0087a;
        a.InterfaceC0087a interfaceC0087a2;
        interfaceC0087a = this.fXP.fXO;
        if (interfaceC0087a != null) {
            interfaceC0087a2 = this.fXP.fXO;
            interfaceC0087a2.tt(this.aaj);
        }
    }
}
