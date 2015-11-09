package com.baidu.tieba.write.view.PhotoLiveView;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class c implements com.baidu.tbadk.imageManager.b {
    private final /* synthetic */ ViewGroup aqc;
    final /* synthetic */ a doV;
    private final /* synthetic */ FrameLayout doW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, ViewGroup viewGroup, FrameLayout frameLayout) {
        this.doV = aVar;
        this.aqc = viewGroup;
        this.doW = frameLayout;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        TbImageView tbImageView;
        if (this.aqc != null && (tbImageView = (TbImageView) this.aqc.findViewWithTag(str)) != null && aVar != null) {
            tbImageView.invalidate();
            if (str.startsWith("android.resource://")) {
                this.doW.bringToFront();
            }
        }
    }
}
