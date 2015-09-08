package com.baidu.tieba.write.view.PhotoLiveView;

import android.view.View;
import com.baidu.tieba.write.view.PhotoLiveView.a;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ a dbM;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, int i) {
        this.dbM = aVar;
        this.val$position = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0078a interfaceC0078a;
        a.InterfaceC0078a interfaceC0078a2;
        interfaceC0078a = this.dbM.dbL;
        if (interfaceC0078a != null) {
            interfaceC0078a2 = this.dbM.dbL;
            interfaceC0078a2.lh(this.val$position);
        }
    }
}
