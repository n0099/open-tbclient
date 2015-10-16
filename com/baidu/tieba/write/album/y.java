package com.baidu.tieba.write.album;

import android.view.ViewGroup;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.write.album.x;
/* loaded from: classes.dex */
class y implements com.baidu.tbadk.imageManager.b {
    private final /* synthetic */ ViewGroup arx;
    final /* synthetic */ x dlb;
    private final /* synthetic */ x.a dlc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar, ViewGroup viewGroup, x.a aVar) {
        this.dlb = xVar;
        this.arx = viewGroup;
        this.dlc = aVar;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        HeadImageView headImageView = (HeadImageView) this.arx.findViewWithTag(str);
        if (headImageView != null && aVar != null) {
            headImageView.invalidate();
        } else {
            this.dlc.dlg = false;
        }
    }
}
