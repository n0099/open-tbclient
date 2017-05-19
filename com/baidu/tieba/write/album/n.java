package com.baidu.tieba.write.album;

import android.view.ViewGroup;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class n implements com.baidu.tbadk.imageManager.b {
    private final /* synthetic */ ViewGroup aAq;
    final /* synthetic */ m fMK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, ViewGroup viewGroup) {
        this.fMK = mVar;
        this.aAq = viewGroup;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        HeadImageView headImageView = (HeadImageView) this.aAq.findViewWithTag(str);
        if (headImageView != null && aVar != null) {
            headImageView.invalidate();
        }
    }
}
