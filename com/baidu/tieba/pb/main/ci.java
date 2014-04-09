package com.baidu.tieba.pb.main;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ci implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ bm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(bm bmVar) {
        this.a = bmVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        HeadImageView headImageView;
        HeadImageView headImageView2;
        if (bVar != null) {
            headImageView2 = this.a.v;
            bVar.a(headImageView2);
            return;
        }
        Bitmap a = com.baidu.tbadk.core.util.g.a(com.baidu.tieba.a.g.photo);
        headImageView = this.a.v;
        headImageView.setImageBitmap(a);
    }
}
