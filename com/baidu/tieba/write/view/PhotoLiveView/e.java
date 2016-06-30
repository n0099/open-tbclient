package com.baidu.tieba.write.view.PhotoLiveView;

import android.view.View;
import com.baidu.tieba.write.view.PhotoLiveView.a;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    private final /* synthetic */ int Sx;
    final /* synthetic */ a fGI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, int i) {
        this.fGI = aVar;
        this.Sx = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0084a interfaceC0084a;
        a.InterfaceC0084a interfaceC0084a2;
        interfaceC0084a = this.fGI.fGH;
        if (interfaceC0084a != null) {
            interfaceC0084a2 = this.fGI.fGH;
            interfaceC0084a2.sp(this.Sx);
        }
    }
}
