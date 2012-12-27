package com.baidu.tieba.service;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import com.baidu.tieba.R;
import com.baidu.tieba.write.ba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends AsyncTask {
    int a;
    Uri b;
    String c = null;
    final /* synthetic */ TiebaPrepareImageService d;

    public l(TiebaPrepareImageService tiebaPrepareImageService, int i, Uri uri) {
        this.d = tiebaPrepareImageService;
        this.a = 0;
        this.b = null;
        this.a = i;
        this.b = uri;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Boolean doInBackground(Object... objArr) {
        int i;
        boolean z = true;
        TiebaPrepareImageService.a = true;
        try {
            int i2 = this.a;
            TiebaPrepareImageService tiebaPrepareImageService = this.d;
            Uri uri = this.b;
            i = this.d.f;
            Bitmap a = ba.a(i2, tiebaPrepareImageService, uri, i);
            if (a == null) {
                this.c = this.d.getString(R.string.pic_parser_error);
                z = false;
            } else if (com.baidu.tieba.c.o.a(null, "tieba_resized_image", a, 80) != null) {
                Bitmap a2 = com.baidu.tieba.c.e.a(a, 100);
                if (a2 == null || com.baidu.tieba.c.o.a(null, "tieba_resized_image_display", a2, 80) == null) {
                    this.c = this.d.getString(R.string.error_sd_error);
                    z = false;
                }
            } else {
                this.c = this.d.getString(R.string.error_sd_error);
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

    public void a() {
        this.d.d = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        Intent intent = new Intent("com.baidu.tieba.broadcast.image.resized");
        intent.putExtra("result", bool);
        if (this.c != null) {
            intent.putExtra("error", this.c);
        }
        this.d.sendBroadcast(intent);
    }
}
