package com.baidu.tieba.square;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.view.HeadImageView;
/* loaded from: classes.dex */
class l implements com.baidu.tieba.util.bl {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2527a;
    final /* synthetic */ com.baidu.adp.widget.ImageView.e b;
    final /* synthetic */ k c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, String str, com.baidu.adp.widget.ImageView.e eVar) {
        this.c = kVar;
        this.f2527a = str;
        this.b = eVar;
    }

    @Override // com.baidu.tieba.util.bl
    public boolean a(View view) {
        if ((view instanceof ImageView) && this.f2527a != null && this.f2527a.equals(view.getTag())) {
            HeadImageView headImageView = (HeadImageView) view;
            headImageView.setImageBitmap(this.b.f());
            headImageView.invalidate();
            return false;
        }
        return false;
    }
}
