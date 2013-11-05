package com.baidu.tieba.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.tieba.data.WriteData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bl implements ba {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bn f2445a;
    final /* synthetic */ Activity b;
    final /* synthetic */ int c;
    final /* synthetic */ au d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bn bnVar, Activity activity, int i, au auVar) {
        this.f2445a = bnVar;
        this.b = activity;
        this.c = i;
        this.d = auVar;
    }

    @Override // com.baidu.tieba.util.ba
    public void a(Bitmap bitmap) {
        if (bitmap == null) {
            this.f2445a.b();
            UtilHelper.a((Context) this.b, this.b.getResources().getString(R.string.share_load_img_failed));
        } else if (this.c == 4 || this.c == 3) {
            this.f2445a.b();
            this.d.a(this.c, bitmap);
        } else {
            this.d.a(WriteData.THREAD_TYPE_LBS, new bm(this, bitmap));
        }
    }
}
