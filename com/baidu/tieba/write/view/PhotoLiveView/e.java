package com.baidu.tieba.write.view.PhotoLiveView;

import android.view.View;
import com.baidu.tieba.write.view.PhotoLiveView.a;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    private final /* synthetic */ int VX;
    final /* synthetic */ a fAV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, int i) {
        this.fAV = aVar;
        this.VX = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0079a interfaceC0079a;
        a.InterfaceC0079a interfaceC0079a2;
        interfaceC0079a = this.fAV.fAU;
        if (interfaceC0079a != null) {
            interfaceC0079a2 = this.fAV.fAU;
            interfaceC0079a2.sn(this.VX);
        }
    }
}
