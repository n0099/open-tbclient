package com.baidu.tieba.write;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.bg;
/* loaded from: classes.dex */
public class bb extends BdAsyncTask<Object, Integer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteImagePreview f2702a;
    private String b;

    public bb(WriteImagePreview writeImagePreview, String str) {
        this.f2702a = writeImagePreview;
        this.b = null;
        this.b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Bitmap a(Object... objArr) {
        if (this.b != null && !this.b.equals("tieba_resized_image")) {
            com.baidu.tieba.util.af.e("photos/" + this.b, "tieba_resized_image");
        }
        return com.baidu.tieba.util.af.c(null, "tieba_resized_image_display");
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void c() {
        super.c();
        if (this.f2702a.f != null) {
            this.f2702a.f.a(31, null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Bitmap bitmap) {
        super.a((bb) bitmap);
        bg.a(getClass().getName(), "onPostExecute", "is Null?" + String.valueOf(bitmap == null));
        this.f2702a.a(bitmap);
    }
}
