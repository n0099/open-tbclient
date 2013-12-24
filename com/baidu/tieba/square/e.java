package com.baidu.tieba.square;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.view.HeadImageView;
/* loaded from: classes.dex */
class e implements com.baidu.tieba.util.bm {
    final /* synthetic */ String a;
    final /* synthetic */ com.baidu.adp.widget.ImageView.e b;
    final /* synthetic */ d c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, String str, com.baidu.adp.widget.ImageView.e eVar) {
        this.c = dVar;
        this.a = str;
        this.b = eVar;
    }

    @Override // com.baidu.tieba.util.bm
    public boolean a(View view) {
        if ((view instanceof ImageView) && this.a != null && this.a.equals(view.getTag())) {
            HeadImageView headImageView = (HeadImageView) view;
            headImageView.setImageBitmap(this.b.f());
            headImageView.invalidate();
            return false;
        }
        return false;
    }
}
