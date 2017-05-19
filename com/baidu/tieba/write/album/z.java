package com.baidu.tieba.write.album;

import android.view.ViewGroup;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.write.album.y;
/* loaded from: classes.dex */
class z implements com.baidu.tbadk.imageManager.b {
    private final /* synthetic */ ViewGroup aAq;
    final /* synthetic */ y fNc;
    private final /* synthetic */ y.a fNd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar, ViewGroup viewGroup, y.a aVar) {
        this.fNc = yVar;
        this.aAq = viewGroup;
        this.fNd = aVar;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        HeadImageView headImageView = (HeadImageView) this.aAq.findViewWithTag(str);
        if (headImageView != null && aVar != null) {
            headImageView.invalidate();
        } else {
            this.fNd.fNi = false;
        }
    }
}
