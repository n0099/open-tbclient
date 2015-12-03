package com.baidu.tieba.write.view.PhotoLiveView;

import android.view.View;
import com.baidu.tieba.write.view.PhotoLiveView.a;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ a dOa;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, int i) {
        this.dOa = aVar;
        this.val$position = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0090a interfaceC0090a;
        a.InterfaceC0090a interfaceC0090a2;
        interfaceC0090a = this.dOa.dNZ;
        if (interfaceC0090a != null) {
            interfaceC0090a2 = this.dOa.dNZ;
            interfaceC0090a2.ny(this.val$position);
        }
    }
}
