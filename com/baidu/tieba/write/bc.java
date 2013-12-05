package com.baidu.tieba.write;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class bc extends BdAsyncTask<Object, Integer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteImagePreview f2804a;
    private String b;

    public bc(WriteImagePreview writeImagePreview, String str) {
        this.f2804a = writeImagePreview;
        this.b = null;
        this.b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Bitmap a(Object... objArr) {
        if (this.b != null && !this.b.equals("tieba_resized_image")) {
            com.baidu.tieba.util.x.e("photos/" + this.b, "tieba_resized_image");
        }
        return com.baidu.tieba.util.x.c(null, "tieba_resized_image_display");
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void c() {
        super.c();
        if (this.f2804a.f != null) {
            this.f2804a.f.a(31, null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Bitmap bitmap) {
        super.a((bc) bitmap);
        com.baidu.tieba.util.bd.a(getClass().getName(), "onPostExecute", "is Null?" + String.valueOf(bitmap == null));
        this.f2804a.a(bitmap);
    }
}
