package com.baidu.tieba.square;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.util.ba;
import com.baidu.tieba.view.HeadImageView;
/* loaded from: classes.dex */
class f implements ba {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f1741a;
    private final /* synthetic */ String b;
    private final /* synthetic */ com.baidu.adp.widget.a.b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, String str, com.baidu.adp.widget.a.b bVar) {
        this.f1741a = eVar;
        this.b = str;
        this.c = bVar;
    }

    @Override // com.baidu.tieba.util.ba
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
