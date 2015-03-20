package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class k implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ j cms;
    private final /* synthetic */ ViewGroup cmt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, ViewGroup viewGroup) {
        this.cms = jVar;
        this.cmt = viewGroup;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        TbImageView tbImageView = (TbImageView) this.cmt.findViewWithTag(str);
        if (tbImageView != null && aVar != null) {
            tbImageView.invalidate();
        }
    }
}
