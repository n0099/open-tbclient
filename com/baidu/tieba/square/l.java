package com.baidu.tieba.square;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.view.HeadImageView;
/* loaded from: classes.dex */
class l implements com.baidu.tieba.util.bn {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2410a;
    final /* synthetic */ com.baidu.adp.widget.ImageView.e b;
    final /* synthetic */ k c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, String str, com.baidu.adp.widget.ImageView.e eVar) {
        this.c = kVar;
        this.f2410a = str;
        this.b = eVar;
    }

    @Override // com.baidu.tieba.util.bn
    public boolean a(View view) {
        if ((view instanceof ImageView) && this.f2410a != null && this.f2410a.equals(view.getTag())) {
            HeadImageView headImageView = (HeadImageView) view;
            headImageView.setImageBitmap(this.b.f());
            headImageView.invalidate();
            return false;
        }
        return false;
    }
}
