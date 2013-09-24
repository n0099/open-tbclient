package com.baidu.tieba.square;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.util.bf;
import com.baidu.tieba.view.HeadImageView;
/* loaded from: classes.dex */
class f implements bf {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f1840a;
    private final /* synthetic */ String b;
    private final /* synthetic */ com.baidu.adp.widget.a.c c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, String str, com.baidu.adp.widget.a.c cVar) {
        this.f1840a = eVar;
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
