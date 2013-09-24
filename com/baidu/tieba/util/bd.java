package com.baidu.tieba.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class bd implements aq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bc f1916a;
    private final /* synthetic */ be b;
    private final /* synthetic */ Activity c;
    private final /* synthetic */ al d;
    private final /* synthetic */ int e;
    private final /* synthetic */ Bitmap f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bc bcVar, be beVar, Activity activity, al alVar, int i, Bitmap bitmap) {
        this.f1916a = bcVar;
        this.b = beVar;
        this.c = activity;
        this.d = alVar;
        this.e = i;
        this.f = bitmap;
    }

    @Override // com.baidu.tieba.util.aq
    public void a(String str) {
        this.b.b();
        if (str == null) {
            UtilHelper.a((Context) this.c, this.c.getResources().getString(R.string.share_load_img_failed));
        } else {
            this.d.a(this.e, str, this.f, this.c.getResources().getString(R.string.share_iamge_title_default));
        }
    }
}
