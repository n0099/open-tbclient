package com.baidu.tieba.view;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GuidPageView f1854a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(GuidPageView guidPageView) {
        this.f1854a = guidPageView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && view.getBackground() != null) {
            Bitmap bitmap = ((BitmapDrawable) view.getBackground()).getBitmap();
            view.setBackgroundDrawable(null);
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            view.setVisibility(8);
        }
    }
}
