package com.baidu.tieba.write.view.PhotoLiveView;

import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class c implements com.baidu.tbadk.imageManager.b {
    private final /* synthetic */ ViewGroup asz;
    final /* synthetic */ a fSz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, ViewGroup viewGroup) {
        this.fSz = aVar;
        this.asz = viewGroup;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        TbImageView tbImageView;
        if (this.asz != null && (tbImageView = (TbImageView) this.asz.findViewWithTag(str)) != null && aVar != null) {
            tbImageView.invalidate();
        }
    }
}
