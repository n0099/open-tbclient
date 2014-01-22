package com.baidu.tieba.square;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.util.cg;
import com.baidu.tieba.view.HeadImageView;
/* loaded from: classes.dex */
class e implements cg {
    final /* synthetic */ String a;
    final /* synthetic */ com.baidu.adp.widget.ImageView.d b;
    final /* synthetic */ d c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, String str, com.baidu.adp.widget.ImageView.d dVar2) {
        this.c = dVar;
        this.a = str;
        this.b = dVar2;
    }

    @Override // com.baidu.tieba.util.cg
    public boolean a(View view) {
        if ((view instanceof ImageView) && this.a != null && this.a.equals(view.getTag())) {
            HeadImageView headImageView = (HeadImageView) view;
            headImageView.setImageBitmap(this.b.h());
            headImageView.invalidate();
            return false;
        }
        return false;
    }
}
