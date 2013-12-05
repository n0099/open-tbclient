package com.baidu.tieba.mention;

import android.widget.ImageView;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PostActivity f1970a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PostActivity postActivity) {
        this.f1970a = postActivity;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        linearLayout = this.f1970a.f1941a;
        ImageView imageView = (ImageView) linearLayout.findViewWithTag(str);
        while (imageView != null) {
            imageView.setTag(null);
            if (imageView != null && eVar != null) {
                eVar.a(imageView);
            }
            linearLayout2 = this.f1970a.f1941a;
            imageView = (ImageView) linearLayout2.findViewWithTag(str);
        }
    }
}
