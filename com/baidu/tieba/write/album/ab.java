package com.baidu.tieba.write.album;

import android.view.ViewGroup;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class ab implements com.baidu.tbadk.imageManager.d {
    private final /* synthetic */ ViewGroup cmJ;
    final /* synthetic */ aa cuK;
    private final /* synthetic */ af cuL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar, ViewGroup viewGroup, af afVar) {
        this.cuK = aaVar;
        this.cmJ = viewGroup;
        this.cuL = afVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        HeadImageView headImageView = (HeadImageView) this.cmJ.findViewWithTag(str);
        if (headImageView != null && aVar != null) {
            headImageView.invalidate();
        } else {
            this.cuL.cuP = false;
        }
    }
}
