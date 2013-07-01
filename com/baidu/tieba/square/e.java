package com.baidu.tieba.square;

import android.view.ViewGroup;
import android.widget.ImageView;
/* loaded from: classes.dex */
class e implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f1431a;
    private final /* synthetic */ ViewGroup b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, ViewGroup viewGroup) {
        this.f1431a = cVar;
        this.b = viewGroup;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        while (true) {
            ImageView imageView = (ImageView) this.b.findViewWithTag(str);
            if (imageView != null) {
                imageView.setTag(null);
                bVar.b(imageView);
            } else {
                return;
            }
        }
    }
}
