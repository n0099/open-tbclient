package com.baidu.tieba.write.album;

import android.view.ViewGroup;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class m implements com.baidu.tbadk.imageManager.d {
    private final /* synthetic */ ViewGroup cqI;
    final /* synthetic */ l cyv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, ViewGroup viewGroup) {
        this.cyv = lVar;
        this.cqI = viewGroup;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        HeadImageView headImageView = (HeadImageView) this.cqI.findViewWithTag(str);
        if (headImageView != null && aVar != null) {
            headImageView.invalidate();
        }
    }
}
