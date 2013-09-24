package com.baidu.tieba.square;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.util.bf;
import com.baidu.tieba.view.HeadImageView;
/* loaded from: classes.dex */
class k implements bf {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f1845a;
    private final /* synthetic */ String b;
    private final /* synthetic */ com.baidu.adp.widget.a.c c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, String str, com.baidu.adp.widget.a.c cVar) {
        this.f1845a = jVar;
        this.b = str;
        this.c = cVar;
    }

    @Override // com.baidu.tieba.util.bf
    public boolean a(View view) {
        if ((view instanceof ImageView) && this.b != null && this.b.equals(view.getTag())) {
            HeadImageView headImageView = (HeadImageView) view;
            headImageView.setImageBitmap(this.c.f());
            headImageView.invalidate();
            return false;
        }
        return false;
    }
}
