package com.baidu.tieba.write.view.PhotoLiveView;

import android.view.View;
import com.baidu.tieba.write.view.PhotoLiveView.a;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    private final /* synthetic */ int Sg;
    final /* synthetic */ a fbe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, int i) {
        this.fbe = aVar;
        this.Sg = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0082a interfaceC0082a;
        a.InterfaceC0082a interfaceC0082a2;
        interfaceC0082a = this.fbe.fbd;
        if (interfaceC0082a != null) {
            interfaceC0082a2 = this.fbe.fbd;
            interfaceC0082a2.qZ(this.Sg);
        }
    }
}
