package com.baidu.tieba.service;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import com.baidu.tieba.write.bb;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.lib.a.a {
    int a;
    Uri b;
    String c = null;
    final /* synthetic */ TiebaPrepareImageService d;

    public p(TiebaPrepareImageService tiebaPrepareImageService, int i, Uri uri) {
        this.d = tiebaPrepareImageService;
        this.a = 0;
        this.b = null;
        this.a = i;
        this.b = uri;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: d */
    public Boolean a(Object... objArr) {
        int i;
        boolean z = true;
        TiebaPrepareImageService.a = true;
        try {
            int i2 = this.a;
            TiebaPrepareImageService tiebaPrepareImageService = this.d;
            Uri uri = this.b;
            i = this.d.f;
            Bitmap a = bb.a(i2, tiebaPrepareImageService, uri, i);
            if (a != null) {
                if (com.baidu.tieba.d.o.a(null, "tieba_resized_image", a, 80) != null) {
                    Bitmap a2 = com.baidu.tieba.d.e.a(a, 100);
                    if (a2 == null || com.baidu.tieba.d.o.a(null, "tieba_resized_image_display", a2, 80) == null) {
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

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        this.d.d = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
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
