package com.baidu.tieba.write.view.PhotoLiveView;

import android.view.View;
import com.baidu.tieba.write.view.PhotoLiveView.a;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    private final /* synthetic */ int Vn;
    final /* synthetic */ a fJq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, int i) {
        this.fJq = aVar;
        this.Vn = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0079a interfaceC0079a;
        a.InterfaceC0079a interfaceC0079a2;
        interfaceC0079a = this.fJq.fJp;
        if (interfaceC0079a != null) {
            interfaceC0079a2 = this.fJq.fJp;
            interfaceC0079a2.sY(this.Vn);
        }
    }
}
