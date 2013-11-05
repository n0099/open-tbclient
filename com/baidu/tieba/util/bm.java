package com.baidu.tieba.util;

import android.content.Context;
import android.graphics.Bitmap;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class bm implements az {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Bitmap f2446a;
    final /* synthetic */ bl b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bl blVar, Bitmap bitmap) {
        this.b = blVar;
        this.f2446a = bitmap;
    }

    @Override // com.baidu.tieba.util.az
    public void a(String str) {
        this.b.f2445a.b();
        if (str == null) {
            UtilHelper.a((Context) this.b.b, this.b.b.getResources().getString(R.string.share_load_img_failed));
        } else {
            this.b.d.a(this.b.c, str, this.f2446a, this.b.b.getResources().getString(R.string.share_iamge_title_default));
        }
    }
}
