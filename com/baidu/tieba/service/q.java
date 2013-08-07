package com.baidu.tieba.service;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.write.ba;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    int f1709a;
    Uri b;
    String c = null;
    final /* synthetic */ TiebaPrepareImageService d;

    public q(TiebaPrepareImageService tiebaPrepareImageService, int i, Uri uri) {
        this.d = tiebaPrepareImageService;
        this.f1709a = 0;
        this.b = null;
        this.f1709a = i;
        this.b = uri;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Boolean a(Object... objArr) {
        int i;
        boolean z = true;
        TiebaPrepareImageService.f1690a = true;
        try {
            int i2 = this.f1709a;
            TiebaPrepareImageService tiebaPrepareImageService = this.d;
            Uri uri = this.b;
            i = this.d.f;
            Bitmap a2 = ba.a(i2, tiebaPrepareImageService, uri, i);
            if (a2 != null) {
                if (com.baidu.tieba.util.p.a(null, "tieba_resized_image", a2, 80) != null) {
                    Bitmap a3 = com.baidu.tieba.util.e.a(a2, 100);
                    if (a3 == null || com.baidu.tieba.util.p.a(null, "tieba_resized_image_display", a3, 80) == null) {
                        this.c = this.d.getString(R.string.error_sd_error);
                        z = false;
                    }
                } else {
                    this.c = this.d.getString(R.string.error_sd_error);
                    z = false;
                }
            } else {
                this.c = this.d.getString(R.string.pic_parser_error);
                z = false;
            }
            TiebaPrepareImageService.f1690a = false;
        } catch (Exception e) {
            TiebaPrepareImageService.f1690a = false;
            z = false;
        } catch (Throwable th) {
            TiebaPrepareImageService.f1690a = false;
            throw th;
        }
        return Boolean.valueOf(z);
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
        super.a((Object) bool);
        Intent intent = new Intent("com.baidu.tieba.broadcast.image.resized");
        intent.putExtra("result", bool);
        if (this.c != null) {
            intent.putExtra("error", this.c);
        }
        this.d.sendBroadcast(intent);
    }
}
