package com.baidu.tieba.write.view.PhotoLiveView;

import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class c implements com.baidu.tbadk.imageManager.b {
    private final /* synthetic */ ViewGroup avA;
    final /* synthetic */ a fAV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, ViewGroup viewGroup) {
        this.fAV = aVar;
        this.avA = viewGroup;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        TbImageView tbImageView;
        if (this.avA != null && (tbImageView = (TbImageView) this.avA.findViewWithTag(str)) != null && aVar != null) {
            tbImageView.invalidate();
        }
    }
}
