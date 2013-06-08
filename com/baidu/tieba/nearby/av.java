package com.baidu.tieba.nearby;

import android.widget.AbsoluteLayout;
import android.widget.ImageView;
/* loaded from: classes.dex */
class av implements com.baidu.tbadk.a.d {
    final /* synthetic */ NewNearbyActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(NewNearbyActivity newNearbyActivity) {
        this.a = newNearbyActivity;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        AbsoluteLayout absoluteLayout;
        AbsoluteLayout absoluteLayout2;
        if (bVar != null) {
            absoluteLayout = this.a.g;
            ImageView imageView = (ImageView) absoluteLayout.findViewWithTag(str);
            while (imageView != null) {
                imageView.setTag(null);
                bVar.b(imageView);
                absoluteLayout2 = this.a.g;
                imageView = (ImageView) absoluteLayout2.findViewWithTag(str);
            }
        }
    }
}
