package com.baidu.tieba.nearby;

import android.widget.AbsoluteLayout;
import android.widget.ImageView;
/* loaded from: classes.dex */
class av implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewNearbyActivity f1144a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(NewNearbyActivity newNearbyActivity) {
        this.f1144a = newNearbyActivity;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        AbsoluteLayout absoluteLayout;
        AbsoluteLayout absoluteLayout2;
        if (bVar != null) {
            absoluteLayout = this.f1144a.e;
            ImageView imageView = (ImageView) absoluteLayout.findViewWithTag(str);
            while (imageView != null) {
                imageView.setTag(null);
                bVar.b(imageView);
                absoluteLayout2 = this.f1144a.e;
                imageView = (ImageView) absoluteLayout2.findViewWithTag(str);
            }
        }
    }
}
