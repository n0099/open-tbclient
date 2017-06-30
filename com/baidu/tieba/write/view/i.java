package com.baidu.tieba.write.view;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tieba.write.view.NewFrameMultiImgToolView;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    private final /* synthetic */ FrameLayout aBg;
    final /* synthetic */ NewFrameMultiImgToolView.b giL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(NewFrameMultiImgToolView.b bVar, FrameLayout frameLayout) {
        this.giL = bVar;
        this.aBg = frameLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NewFrameMultiImgToolView.a aVar;
        NewFrameMultiImgToolView.a aVar2;
        aVar = this.giL.giK;
        if (aVar != null) {
            aVar2 = this.giL.giK;
            aVar2.G(this.aBg);
        }
    }
}
