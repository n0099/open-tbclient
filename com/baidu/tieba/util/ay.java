package com.baidu.tieba.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ay implements am {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ax f1795a;
    private final /* synthetic */ az b;
    private final /* synthetic */ Activity c;
    private final /* synthetic */ ah d;
    private final /* synthetic */ int e;
    private final /* synthetic */ Bitmap f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(ax axVar, az azVar, Activity activity, ah ahVar, int i, Bitmap bitmap) {
        this.f1795a = axVar;
        this.b = azVar;
        this.c = activity;
        this.d = ahVar;
        this.e = i;
        this.f = bitmap;
    }

    @Override // com.baidu.tieba.util.am
    public void a(String str) {
        this.b.b();
        if (str == null) {
            UtilHelper.a((Context) this.c, this.c.getResources().getString(R.string.share_load_img_failed));
        } else {
            this.d.a(this.e, str, this.f, this.c.getResources().getString(R.string.share_iamge_title_default));
        }
    }
}
