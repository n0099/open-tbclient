package com.baidu.tieba.write.album;

import android.view.ViewGroup;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class m implements com.baidu.tbadk.imageManager.b {
    private final /* synthetic */ ViewGroup auv;
    final /* synthetic */ l enk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, ViewGroup viewGroup) {
        this.enk = lVar;
        this.auv = viewGroup;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        HeadImageView headImageView = (HeadImageView) this.auv.findViewWithTag(str);
        if (headImageView != null && aVar != null) {
            headImageView.invalidate();
        }
    }
}
