package com.baidu.tieba.write.view.PhotoLiveView;

import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class c implements com.baidu.tbadk.imageManager.b {
    private final /* synthetic */ ViewGroup aAa;
    final /* synthetic */ a fNJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, ViewGroup viewGroup) {
        this.fNJ = aVar;
        this.aAa = viewGroup;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        TbImageView tbImageView;
        if (this.aAa != null && (tbImageView = (TbImageView) this.aAa.findViewWithTag(str)) != null && aVar != null) {
            tbImageView.invalidate();
        }
    }
}
