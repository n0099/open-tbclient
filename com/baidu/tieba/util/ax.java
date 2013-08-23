package com.baidu.tieba.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.tieba.data.WriteData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements an {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ az f1794a;
    private final /* synthetic */ Activity b;
    private final /* synthetic */ int c;
    private final /* synthetic */ ah d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(az azVar, Activity activity, int i, ah ahVar) {
        this.f1794a = azVar;
        this.b = activity;
        this.c = i;
        this.d = ahVar;
    }

    @Override // com.baidu.tieba.util.an
    public void a(Bitmap bitmap) {
        if (bitmap == null) {
            this.f1794a.b();
            UtilHelper.a((Context) this.b, this.b.getResources().getString(R.string.share_load_img_failed));
        } else if (this.c == 4 || this.c == 3) {
            this.f1794a.b();
            this.d.a(this.c, bitmap);
        } else {
            this.d.a(WriteData.THREAD_TYPE_LBS, new ay(this, this.f1794a, this.b, this.d, this.c, bitmap));
        }
    }
}
