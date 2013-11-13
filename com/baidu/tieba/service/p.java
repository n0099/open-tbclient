package com.baidu.tieba.service;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.af;
import com.baidu.tieba.write.bc;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BdAsyncTask<Object, Integer, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    int f2352a;
    Uri b;
    String c = null;
    final /* synthetic */ TiebaPrepareImageService d;

    public p(TiebaPrepareImageService tiebaPrepareImageService, int i, Uri uri) {
        this.d = tiebaPrepareImageService;
        this.f2352a = 0;
        this.b = null;
        this.f2352a = i;
        this.b = uri;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Boolean a(Object... objArr) {
        int i;
        Bitmap a2;
        int i2;
        boolean z = true;
        boolean z2 = false;
        TiebaPrepareImageService.f2335a = true;
        try {
            int i3 = this.f2352a;
            TiebaPrepareImageService tiebaPrepareImageService = this.d;
            Uri uri = this.b;
            i = this.d.f;
            a2 = bc.a(i3, tiebaPrepareImageService, uri, i);
        } catch (Exception e) {
            TiebaPrepareImageService.f2335a = false;
        } catch (Throwable th) {
            TiebaPrepareImageService.f2335a = false;
            throw th;
        }
        if (a2 != null) {
            if (af.a((String) null, "tieba_resized_image", a2, 80) != null) {
                int i4 = 100;
                i2 = this.d.g;
                if (i2 > 0) {
                    i4 = this.d.g;
                }
                Bitmap a3 = com.baidu.tieba.util.m.a(a2, i4);
                if (a3 == null || af.a((String) null, "tieba_resized_image_display", a3, 80) == null) {
                    this.c = this.d.getString(R.string.error_sd_error);
                }
            } else {
                this.c = this.d.getString(R.string.error_sd_error);
                z = false;
            }
            TiebaPrepareImageService.f2335a = false;
            z2 = z;
            return Boolean.valueOf(z2);
        }
        this.c = this.d.getString(R.string.pic_parser_error);
        z = false;
        TiebaPrepareImageService.f2335a = false;
        z2 = z;
        return Boolean.valueOf(z2);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.d.d = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        super.a((p) bool);
        Intent intent = new Intent("com.baidu.tieba.broadcast.image.resized");
        intent.putExtra("result", bool);
        if (this.c != null) {
            intent.putExtra("error", this.c);
        }
        this.d.sendBroadcast(intent);
    }
}
