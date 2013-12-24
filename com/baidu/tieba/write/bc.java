package com.baidu.tieba.write;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.be;
/* loaded from: classes.dex */
public class bc extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ WriteImagePreview a;
    private String b;

    public bc(WriteImagePreview writeImagePreview, String str) {
        this.a = writeImagePreview;
        this.b = null;
        this.b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Bitmap a(Object... objArr) {
        if (this.b != null && !this.b.equals("tieba_resized_image")) {
            com.baidu.tieba.util.y.e("photos/" + this.b, "tieba_resized_image");
        }
        return com.baidu.tieba.util.y.c(null, "tieba_resized_image_display");
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void c() {
        super.c();
        if (this.a.f != null) {
            this.a.f.a(31, null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Bitmap bitmap) {
        super.a((bc) bitmap);
        be.a(getClass().getName(), "onPostExecute", "is Null?" + String.valueOf(bitmap == null));
        this.a.a(bitmap);
    }
}
