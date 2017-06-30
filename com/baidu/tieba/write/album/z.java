package com.baidu.tieba.write.album;

import android.view.ViewGroup;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.write.album.y;
/* loaded from: classes.dex */
class z implements com.baidu.tbadk.imageManager.b {
    private final /* synthetic */ ViewGroup aBf;
    final /* synthetic */ y gft;
    private final /* synthetic */ y.a gfu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar, ViewGroup viewGroup, y.a aVar) {
        this.gft = yVar;
        this.aBf = viewGroup;
        this.gfu = aVar;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        HeadImageView headImageView = (HeadImageView) this.aBf.findViewWithTag(str);
        if (headImageView != null && aVar != null) {
            headImageView.invalidate();
        } else {
            this.gfu.gfz = false;
        }
    }
}
