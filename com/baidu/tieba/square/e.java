package com.baidu.tieba.square;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.util.bo;
import com.baidu.tieba.view.HeadImageView;
/* loaded from: classes.dex */
class e implements bo {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2361a;
    final /* synthetic */ com.baidu.adp.widget.ImageView.e b;
    final /* synthetic */ d c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, String str, com.baidu.adp.widget.ImageView.e eVar) {
        this.c = dVar;
        this.f2361a = str;
        this.b = eVar;
    }

    @Override // com.baidu.tieba.util.bo
    public boolean a(View view) {
        if ((view instanceof ImageView) && this.f2361a != null && this.f2361a.equals(view.getTag())) {
            HeadImageView headImageView = (HeadImageView) view;
            headImageView.setImageBitmap(this.b.f());
            headImageView.invalidate();
            return false;
        }
        return false;
    }
}
