package com.baidu.tieba.square;

import android.widget.ImageView;
/* loaded from: classes.dex */
class av implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ au f1833a;
    private final /* synthetic */ ImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(au auVar, ImageView imageView) {
        this.f1833a = auVar;
        this.b = imageView;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.c cVar, String str, boolean z) {
        if (cVar != null) {
            this.b.invalidate();
        }
    }
}
