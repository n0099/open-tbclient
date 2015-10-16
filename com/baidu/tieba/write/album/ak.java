package com.baidu.tieba.write.album;

import android.widget.GridView;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ ac dlo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ac acVar) {
        this.dlo = acVar;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        GridView gridView;
        gridView = this.dlo.mGridView;
        HeadImageView headImageView = (HeadImageView) gridView.findViewWithTag(str);
        if (headImageView != null && aVar != null) {
            headImageView.invalidate();
        }
    }
}
