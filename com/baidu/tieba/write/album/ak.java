package com.baidu.tieba.write.album;

import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ ac fNP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ac acVar) {
        this.fNP = acVar;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        TransparentHeadGridView transparentHeadGridView;
        transparentHeadGridView = this.fNP.fNo;
        HeadImageView headImageView = (HeadImageView) transparentHeadGridView.findViewWithTag(str);
        if (headImageView != null && aVar != null) {
            headImageView.invalidate();
        }
    }
}
