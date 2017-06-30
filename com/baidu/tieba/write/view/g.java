package com.baidu.tieba.write.view;

import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.write.view.NewFrameMultiImgToolView;
/* loaded from: classes.dex */
class g implements com.baidu.tbadk.imageManager.b {
    private final /* synthetic */ ViewGroup aBf;
    final /* synthetic */ NewFrameMultiImgToolView.b giL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(NewFrameMultiImgToolView.b bVar, ViewGroup viewGroup) {
        this.giL = bVar;
        this.aBf = viewGroup;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        TbImageView tbImageView = (TbImageView) this.aBf.findViewWithTag(str);
        if (tbImageView != null && aVar != null) {
            tbImageView.invalidate();
        }
    }
}
