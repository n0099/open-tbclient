package com.baidu.tieba.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.tieba.data.WriteData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements ar {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ be f1915a;
    private final /* synthetic */ Activity b;
    private final /* synthetic */ int c;
    private final /* synthetic */ al d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(be beVar, Activity activity, int i, al alVar) {
        this.f1915a = beVar;
        this.b = activity;
        this.c = i;
        this.d = alVar;
    }

    @Override // com.baidu.tieba.util.ar
    public void a(Bitmap bitmap) {
        if (bitmap == null) {
            this.f1915a.b();
            UtilHelper.a((Context) this.b, this.b.getResources().getString(R.string.share_load_img_failed));
        } else if (this.c == 4 || this.c == 3) {
            this.f1915a.b();
            this.d.a(this.c, bitmap);
        } else {
            this.d.a(WriteData.THREAD_TYPE_LBS, new bd(this, this.f1915a, this.b, this.d, this.c, bitmap));
        }
    }
}
