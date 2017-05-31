package com.baidu.tieba.write.album;

import android.view.ViewGroup;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.write.album.y;
/* loaded from: classes.dex */
class z implements com.baidu.tbadk.imageManager.b {
    private final /* synthetic */ ViewGroup aAc;
    final /* synthetic */ y fUJ;
    private final /* synthetic */ y.a fUK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar, ViewGroup viewGroup, y.a aVar) {
        this.fUJ = yVar;
        this.aAc = viewGroup;
        this.fUK = aVar;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        HeadImageView headImageView = (HeadImageView) this.aAc.findViewWithTag(str);
        if (headImageView != null && aVar != null) {
            headImageView.invalidate();
        } else {
            this.fUK.fUP = false;
        }
    }
}
