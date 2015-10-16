package com.baidu.tieba.write.view.PhotoLiveView;

import android.view.View;
import com.baidu.tieba.write.view.PhotoLiveView.a;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ a dnn;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, int i) {
        this.dnn = aVar;
        this.val$position = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0081a interfaceC0081a;
        a.InterfaceC0081a interfaceC0081a2;
        interfaceC0081a = this.dnn.dnm;
        if (interfaceC0081a != null) {
            interfaceC0081a2 = this.dnn.dnm;
            interfaceC0081a2.lY(this.val$position);
        }
    }
}
