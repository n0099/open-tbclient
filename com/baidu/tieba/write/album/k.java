package com.baidu.tieba.write.album;

import android.view.ViewGroup;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class k implements com.baidu.tbadk.imageManager.b {
    private final /* synthetic */ ViewGroup aqc;
    final /* synthetic */ j dlZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, ViewGroup viewGroup) {
        this.dlZ = jVar;
        this.aqc = viewGroup;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        HeadImageView headImageView = (HeadImageView) this.aqc.findViewWithTag(str);
        if (headImageView != null && aVar != null) {
            headImageView.invalidate();
        }
    }
}
