package com.baidu.tieba.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class as implements af {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ar f1758a;
    private final /* synthetic */ at b;
    private final /* synthetic */ Activity c;
    private final /* synthetic */ aa d;
    private final /* synthetic */ int e;
    private final /* synthetic */ Bitmap f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ar arVar, at atVar, Activity activity, aa aaVar, int i, Bitmap bitmap) {
        this.f1758a = arVar;
        this.b = atVar;
        this.c = activity;
        this.d = aaVar;
        this.e = i;
        this.f = bitmap;
    }

    @Override // com.baidu.tieba.util.af
    public void a(String str) {
        this.b.b();
        if (str == null) {
            am.a((Context) this.c, this.c.getResources().getString(R.string.share_load_img_failed));
        } else {
            this.d.a(this.e, str, this.f, this.c.getResources().getString(R.string.share_iamge_title_default));
        }
    }
}
