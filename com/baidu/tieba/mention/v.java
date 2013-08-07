package com.baidu.tieba.mention;

import android.widget.ImageView;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PostActivity f1310a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(PostActivity postActivity) {
        this.f1310a = postActivity;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        linearLayout = this.f1310a.f1287a;
        ImageView imageView = (ImageView) linearLayout.findViewWithTag(str);
        while (imageView != null) {
            imageView.setTag(null);
            if (imageView != null && bVar != null) {
                bVar.b(imageView);
            }
            linearLayout2 = this.f1310a.f1287a;
            imageView = (ImageView) linearLayout2.findViewWithTag(str);
        }
    }
}
