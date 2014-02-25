package com.baidu.tieba.service;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.af;
import com.baidu.tieba.write.bz;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends BdAsyncTask<Object, Integer, Boolean> {
    int a;
    Uri b;
    String c = null;
    final /* synthetic */ TiebaPrepareImageService d;

    public o(TiebaPrepareImageService tiebaPrepareImageService, int i, Uri uri) {
        this.d = tiebaPrepareImageService;
        this.a = 0;
        this.b = null;
        this.a = i;
        this.b = uri;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Boolean a(Object... objArr) {
        int i;
        int i2;
        boolean z = true;
        TiebaPrepareImageService.a = true;
        try {
            int i3 = this.a;
            TiebaPrepareImageService tiebaPrepareImageService = this.d;
            Uri uri = this.b;
            i = this.d.f;
            Bitmap a = bz.a(i3, tiebaPrepareImageService, uri, i);
            if (a != null) {
                if (af.a((String) null, "tieba_resized_image", a, 80) != null) {
                    int i4 = 100;
                    i2 = this.d.g;
                    if (i2 > 0) {
                        i4 = this.d.g;
                    }
                    Bitmap a2 = com.baidu.tieba.util.n.a(a, i4);
                    if (a2 == null || af.a((String) null, "tieba_resized_image_display", a2, 80) == null) {
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
            TiebaPrepareImageService.a = false;
        } catch (Exception e) {
            TiebaPrepareImageService.a = false;
            z = false;
        } catch (Throwable th) {
            TiebaPrepareImageService.a = false;
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
        super.a((o) bool);
        Intent intent = new Intent(com.baidu.tieba.data.i.b());
        intent.putExtra("result", bool);
        if (this.c != null) {
            intent.putExtra("error", this.c);
        }
        this.d.sendBroadcast(intent);
    }
}
