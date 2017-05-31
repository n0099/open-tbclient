package com.baidu.tieba.write.view;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tieba.write.view.NewFrameMultiImgToolView;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    private final /* synthetic */ FrameLayout aAd;
    final /* synthetic */ NewFrameMultiImgToolView.b fXL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(NewFrameMultiImgToolView.b bVar, FrameLayout frameLayout) {
        this.fXL = bVar;
        this.aAd = frameLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NewFrameMultiImgToolView.a aVar;
        NewFrameMultiImgToolView.a aVar2;
        aVar = this.fXL.fXK;
        if (aVar != null) {
            aVar2 = this.fXL.fXK;
            aVar2.F(this.aAd);
        }
    }
}
