package com.baidu.tieba.write.album;

import android.view.ViewGroup;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class ad implements com.baidu.tbadk.imageManager.d {
    private final /* synthetic */ ViewGroup cqI;
    final /* synthetic */ ac czc;
    private final /* synthetic */ ah czd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar, ViewGroup viewGroup, ah ahVar) {
        this.czc = acVar;
        this.cqI = viewGroup;
        this.czd = ahVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        HeadImageView headImageView = (HeadImageView) this.cqI.findViewWithTag(str);
        if (headImageView != null && aVar != null) {
            headImageView.invalidate();
        } else {
            this.czd.czh = false;
        }
    }
}
