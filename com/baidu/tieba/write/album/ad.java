package com.baidu.tieba.write.album;

import android.view.ViewGroup;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class ad implements com.baidu.tbadk.imageManager.d {
    private final /* synthetic */ ViewGroup cqJ;
    final /* synthetic */ ac czd;
    private final /* synthetic */ ah cze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar, ViewGroup viewGroup, ah ahVar) {
        this.czd = acVar;
        this.cqJ = viewGroup;
        this.cze = ahVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        HeadImageView headImageView = (HeadImageView) this.cqJ.findViewWithTag(str);
        if (headImageView != null && aVar != null) {
            headImageView.invalidate();
        } else {
            this.cze.czi = false;
        }
    }
}
