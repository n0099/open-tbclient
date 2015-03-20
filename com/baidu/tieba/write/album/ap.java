package com.baidu.tieba.write.album;

import android.widget.GridView;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ ah cuH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ah ahVar) {
        this.cuH = ahVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        GridView gridView;
        gridView = this.cuH.bAv;
        HeadImageView headImageView = (HeadImageView) gridView.findViewWithTag(str);
        if (headImageView != null && aVar != null) {
            headImageView.invalidate();
        }
    }
}
