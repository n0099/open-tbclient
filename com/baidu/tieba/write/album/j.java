package com.baidu.tieba.write.album;

import android.view.ViewGroup;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class j implements com.baidu.tbadk.imageManager.b {
    private final /* synthetic */ ViewGroup arw;
    final /* synthetic */ i djR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, ViewGroup viewGroup) {
        this.djR = iVar;
        this.arw = viewGroup;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        HeadImageView headImageView = (HeadImageView) this.arw.findViewWithTag(str);
        if (headImageView != null && aVar != null) {
            headImageView.invalidate();
        }
    }
}
