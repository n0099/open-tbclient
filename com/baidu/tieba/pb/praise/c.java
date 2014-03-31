package com.baidu.tieba.pb.praise;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ b a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, String str) {
        this.a = bVar;
        this.b = str;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        HeadImageView headImageView;
        HeadImageView headImageView2;
        HeadImageView headImageView3;
        HeadImageView headImageView4;
        if (bVar != null) {
            headImageView3 = this.a.b;
            headImageView3.setTag(null);
            headImageView4 = this.a.b;
            bVar.a(headImageView4);
            return;
        }
        headImageView = this.a.b;
        headImageView.setTag(this.b);
        Bitmap a = com.baidu.tbadk.core.util.g.a(com.baidu.tieba.a.g.photo);
        headImageView2 = this.a.b;
        headImageView2.setImageBitmap(a);
    }
}
