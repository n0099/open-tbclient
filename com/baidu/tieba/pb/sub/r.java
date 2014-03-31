package com.baidu.tieba.pb.sub;

import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(m mVar) {
        this.a = mVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (bVar != null) {
            ImageView imageView = (ImageView) this.a.d.findViewWithTag(str);
            while (imageView != null) {
                imageView.setTag(null);
                bVar.a(imageView);
                imageView = (ImageView) this.a.d.findViewWithTag(str);
            }
        }
    }
}
