package com.baidu.tieba.write.shareSDK;

import android.widget.LinearLayout;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ q cwf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar) {
        this.cwf = qVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        LinearLayout linearLayout;
        linearLayout = this.cwf.cvY;
        TbImageView tbImageView = (TbImageView) linearLayout.findViewWithTag(str);
        if (tbImageView != null && aVar != null) {
            tbImageView.invalidate();
        }
    }
}
