package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class v implements com.baidu.tbadk.imageManager.d {
    private final /* synthetic */ ViewGroup aqh;
    final /* synthetic */ u bWe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, ViewGroup viewGroup) {
        this.bWe = uVar;
        this.aqh = viewGroup;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        TbImageView tbImageView = (TbImageView) this.aqh.findViewWithTag(str);
        if (tbImageView != null && aVar != null) {
            tbImageView.invalidate();
        }
    }
}
