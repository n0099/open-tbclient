package com.baidu.tieba.square;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.view.HeadImageView;
/* loaded from: classes.dex */
class l implements com.baidu.tieba.util.bw {
    final /* synthetic */ String a;
    final /* synthetic */ com.baidu.adp.widget.ImageView.d b;
    final /* synthetic */ k c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, String str, com.baidu.adp.widget.ImageView.d dVar) {
        this.c = kVar;
        this.a = str;
        this.b = dVar;
    }

    @Override // com.baidu.tieba.util.bw
    public boolean a(View view) {
        if (view != null && (view instanceof ImageView) && this.a != null && this.a.equals(view.getTag())) {
            HeadImageView headImageView = (HeadImageView) view;
            headImageView.setImageBitmap(this.b.h());
            headImageView.invalidate();
        }
        return false;
    }
}
