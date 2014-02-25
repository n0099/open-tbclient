package com.baidu.tieba.mainentrance;

import android.widget.ImageView;
/* loaded from: classes.dex */
class al implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ ak a;
    private final /* synthetic */ ImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar, ImageView imageView) {
        this.a = akVar;
        this.b = imageView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (bVar != null) {
            this.b.invalidate();
        }
    }
}
