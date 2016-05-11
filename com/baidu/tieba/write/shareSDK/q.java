package com.baidu.tieba.write.shareSDK;

import android.widget.LinearLayout;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ o faw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar) {
        this.faw = oVar;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        LinearLayout linearLayout;
        linearLayout = this.faw.fao;
        TbImageView tbImageView = (TbImageView) linearLayout.findViewWithTag(str);
        if (tbImageView != null && aVar != null) {
            tbImageView.invalidate();
        }
    }
}
