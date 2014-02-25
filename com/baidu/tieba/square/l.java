package com.baidu.tieba.square;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.util.cj;
import com.baidu.tieba.view.HeadImageView;
/* loaded from: classes.dex */
class l implements cj {
    final /* synthetic */ k a;
    private final /* synthetic */ String b;
    private final /* synthetic */ com.baidu.adp.widget.ImageView.b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, String str, com.baidu.adp.widget.ImageView.b bVar) {
        this.a = kVar;
        this.b = str;
        this.c = bVar;
    }

    @Override // com.baidu.tieba.util.cj
    public boolean a(View view) {
        if (view != null && (view instanceof ImageView) && this.b != null && this.b.equals(view.getTag())) {
            HeadImageView headImageView = (HeadImageView) view;
            headImageView.setImageBitmap(this.c.h());
            headImageView.invalidate();
        }
        return false;
    }
}
