package com.baidu.tieba.write.view;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tieba.write.view.NewFrameMultiImgToolView;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    private final /* synthetic */ FrameLayout aAr;
    final /* synthetic */ NewFrameMultiImgToolView.b fPP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(NewFrameMultiImgToolView.b bVar, FrameLayout frameLayout) {
        this.fPP = bVar;
        this.aAr = frameLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NewFrameMultiImgToolView.a aVar;
        NewFrameMultiImgToolView.a aVar2;
        aVar = this.fPP.fPO;
        if (aVar != null) {
            aVar2 = this.fPP.fPO;
            aVar2.F(this.aAr);
        }
    }
}
