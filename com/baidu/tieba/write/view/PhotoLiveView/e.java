package com.baidu.tieba.write.view.PhotoLiveView;

import android.view.View;
import com.baidu.tieba.write.view.PhotoLiveView.a;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    private final /* synthetic */ int YA;
    final /* synthetic */ a eqs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, int i) {
        this.eqs = aVar;
        this.YA = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0091a interfaceC0091a;
        a.InterfaceC0091a interfaceC0091a2;
        interfaceC0091a = this.eqs.eqr;
        if (interfaceC0091a != null) {
            interfaceC0091a2 = this.eqs.eqr;
            interfaceC0091a2.pL(this.YA);
        }
    }
}
