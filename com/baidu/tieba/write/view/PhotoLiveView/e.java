package com.baidu.tieba.write.view.PhotoLiveView;

import android.view.View;
import com.baidu.tieba.write.view.PhotoLiveView.a;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ a dmN;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, int i) {
        this.dmN = aVar;
        this.val$position = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0081a interfaceC0081a;
        a.InterfaceC0081a interfaceC0081a2;
        interfaceC0081a = this.dmN.dmM;
        if (interfaceC0081a != null) {
            interfaceC0081a2 = this.dmN.dmM;
            interfaceC0081a2.lW(this.val$position);
        }
    }
}
