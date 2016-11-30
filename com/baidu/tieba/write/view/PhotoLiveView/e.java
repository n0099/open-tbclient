package com.baidu.tieba.write.view.PhotoLiveView;

import android.view.View;
import com.baidu.tieba.write.view.PhotoLiveView.a;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    private final /* synthetic */ int WD;
    final /* synthetic */ a gms;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, int i) {
        this.gms = aVar;
        this.WD = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0085a interfaceC0085a;
        a.InterfaceC0085a interfaceC0085a2;
        interfaceC0085a = this.gms.gmr;
        if (interfaceC0085a != null) {
            interfaceC0085a2 = this.gms.gmr;
            interfaceC0085a2.tO(this.WD);
        }
    }
}
