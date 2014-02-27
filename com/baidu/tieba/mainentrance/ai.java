package com.baidu.tieba.mainentrance;

import android.widget.ImageView;
/* loaded from: classes.dex */
final class ai implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ ah a;
    private final /* synthetic */ ImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar, ImageView imageView) {
        this.a = ahVar;
        this.b = imageView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (bVar != null) {
            this.b.invalidate();
        }
    }
}
