package com.baidu.tieba.write.album;

import android.view.ViewGroup;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class n implements com.baidu.tbadk.imageManager.b {
    private final /* synthetic */ ViewGroup aBf;
    final /* synthetic */ m gfb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, ViewGroup viewGroup) {
        this.gfb = mVar;
        this.aBf = viewGroup;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        HeadImageView headImageView = (HeadImageView) this.aBf.findViewWithTag(str);
        if (headImageView != null && aVar != null) {
            headImageView.invalidate();
        }
    }
}
