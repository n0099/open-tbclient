package com.baidu.tieba.write.view.PhotoLiveView;

import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class c implements com.baidu.tbadk.imageManager.b {
    private final /* synthetic */ ViewGroup avG;
    final /* synthetic */ a gcE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, ViewGroup viewGroup) {
        this.gcE = aVar;
        this.avG = viewGroup;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        TbImageView tbImageView;
        if (this.avG != null && (tbImageView = (TbImageView) this.avG.findViewWithTag(str)) != null && aVar != null) {
            tbImageView.invalidate();
        }
    }
}
