package com.baidu.tieba.write.view.PhotoLiveView;

import android.view.View;
import com.baidu.tieba.write.view.PhotoLiveView.a;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ a dVz;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, int i) {
        this.dVz = aVar;
        this.val$position = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0086a interfaceC0086a;
        a.InterfaceC0086a interfaceC0086a2;
        interfaceC0086a = this.dVz.dVy;
        if (interfaceC0086a != null) {
            interfaceC0086a2 = this.dVz.dVy;
            interfaceC0086a2.oq(this.val$position);
        }
    }
}
