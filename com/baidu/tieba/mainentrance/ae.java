package com.baidu.tieba.mainentrance;

import android.widget.ImageView;
/* loaded from: classes.dex */
class ae implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ ad a;
    private final /* synthetic */ ImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar, ImageView imageView) {
        this.a = adVar;
        this.b = imageView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null) {
            this.b.invalidate();
        }
    }
}
