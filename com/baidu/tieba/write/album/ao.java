package com.baidu.tieba.write.album;

import android.widget.GridView;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ ag eYV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(ag agVar) {
        this.eYV = agVar;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        GridView gridView;
        gridView = this.eYV.cRJ;
        HeadImageView headImageView = (HeadImageView) gridView.findViewWithTag(str);
        if (headImageView != null && aVar != null) {
            headImageView.invalidate();
        }
    }
}
