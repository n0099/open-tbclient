package com.baidu.tieba.square;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.util.bo;
import com.baidu.tieba.view.HeadImageView;
/* loaded from: classes.dex */
class k implements bo {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2367a;
    final /* synthetic */ com.baidu.adp.widget.ImageView.e b;
    final /* synthetic */ j c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, String str, com.baidu.adp.widget.ImageView.e eVar) {
        this.c = jVar;
        this.f2367a = str;
        this.b = eVar;
    }

    @Override // com.baidu.tieba.util.bo
    public boolean a(View view) {
        if ((view instanceof ImageView) && this.f2367a != null && this.f2367a.equals(view.getTag())) {
            HeadImageView headImageView = (HeadImageView) view;
            headImageView.setImageBitmap(this.b.f());
            headImageView.invalidate();
            return false;
        }
        return false;
    }
}
