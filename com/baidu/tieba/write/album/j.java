package com.baidu.tieba.write.album;

import android.view.ViewGroup;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class j implements com.baidu.tbadk.imageManager.b {
    private final /* synthetic */ ViewGroup arx;
    final /* synthetic */ i dkr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, ViewGroup viewGroup) {
        this.dkr = iVar;
        this.arx = viewGroup;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        HeadImageView headImageView = (HeadImageView) this.arx.findViewWithTag(str);
        if (headImageView != null && aVar != null) {
            headImageView.invalidate();
        }
    }
}
