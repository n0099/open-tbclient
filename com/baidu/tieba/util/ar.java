package com.baidu.tieba.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.tieba.data.WriteData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements ag {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ at f1757a;
    private final /* synthetic */ Activity b;
    private final /* synthetic */ int c;
    private final /* synthetic */ aa d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(at atVar, Activity activity, int i, aa aaVar) {
        this.f1757a = atVar;
        this.b = activity;
        this.c = i;
        this.d = aaVar;
    }

    @Override // com.baidu.tieba.util.ag
    public void a(Bitmap bitmap) {
        if (bitmap == null) {
            this.f1757a.b();
            am.a((Context) this.b, this.b.getResources().getString(R.string.share_load_img_failed));
        } else if (this.c == 4 || this.c == 3) {
            this.f1757a.b();
            this.d.a(this.c, bitmap);
        } else {
            this.d.a(WriteData.THREAD_TYPE_LBS, new as(this, this.f1757a, this.b, this.d, this.c, bitmap));
        }
    }
}
