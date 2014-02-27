package com.baidu.tieba.mention;

import android.widget.ImageView;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aa implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ PostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PostActivity postActivity) {
        this.a = postActivity;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        LinearLayout linearLayout;
        while (true) {
            linearLayout = this.a.a;
            ImageView imageView = (ImageView) linearLayout.findViewWithTag(str);
            if (imageView != null) {
                imageView.setTag(null);
                if (imageView != null && bVar != null) {
                    bVar.a(imageView);
                }
            } else {
                return;
            }
        }
    }
}
