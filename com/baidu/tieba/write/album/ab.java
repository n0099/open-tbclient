package com.baidu.tieba.write.album;

import android.view.ViewGroup;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class ab implements com.baidu.tbadk.imageManager.d {
    private final /* synthetic */ ViewGroup cmt;
    final /* synthetic */ aa cuu;
    private final /* synthetic */ af cuv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar, ViewGroup viewGroup, af afVar) {
        this.cuu = aaVar;
        this.cmt = viewGroup;
        this.cuv = afVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        HeadImageView headImageView = (HeadImageView) this.cmt.findViewWithTag(str);
        if (headImageView != null && aVar != null) {
            headImageView.invalidate();
        } else {
            this.cuv.cuz = false;
        }
    }
}
