package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.os.Build;
import android.widget.ImageView;
import android.widget.ProgressBar;
import cn.jingling.lib.filters.FilterFactory;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteImageActivity f1578a;

    private az(WriteImageActivity writeImageActivity) {
        this.f1578a = writeImageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ az(WriteImageActivity writeImageActivity, az azVar) {
        this(writeImageActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Bitmap a(Object... objArr) {
        Bitmap c;
        boolean z;
        HashMap hashMap;
        String[] strArr;
        HashMap hashMap2;
        Bitmap bitmap = null;
        try {
            c = com.baidu.tieba.util.m.c(null, "tieba_resized_image");
        } catch (Exception e) {
            e = e;
        }
        try {
            if (isCancelled() && c != null && !c.isRecycled()) {
                c.recycle();
                return null;
            }
            int a2 = com.baidu.tieba.util.ab.a(this.f1578a, 63.5f);
            if (Build.VERSION.SDK_INT >= 7) {
                z = this.f1578a.v;
                if (z) {
                    Bitmap a3 = com.baidu.tieba.util.d.a(com.baidu.tieba.util.d.b(c, a2), com.baidu.tieba.util.ab.a(this.f1578a, 5.0f));
                    this.f1578a.B = new HashMap();
                    this.f1578a.C = new HashMap();
                    hashMap = this.f1578a.B;
                    hashMap.put("normal", a3);
                    strArr = WriteImageActivity.f1551a;
                    for (String str : strArr) {
                        String substring = str.substring(0, str.indexOf("|"));
                        if (!substring.equals("normal")) {
                            Bitmap apply = FilterFactory.createOneKeyFilter(this.f1578a, substring).apply(this.f1578a, a3.copy(a3.getConfig(), true));
                            hashMap2 = this.f1578a.B;
                            hashMap2.put(substring, apply);
                        }
                    }
                    return c;
                }
            }
            return c;
        } catch (Exception e2) {
            bitmap = c;
            e = e2;
            com.baidu.tieba.util.z.b(getClass().getName(), "GetImageTask", e.toString());
            return bitmap;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        progressBar = this.f1578a.j;
        progressBar.setVisibility(0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.f1578a.k = null;
        progressBar = this.f1578a.j;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Bitmap bitmap) {
        ProgressBar progressBar;
        ImageView imageView;
        boolean z;
        String[] strArr;
        super.a((Object) bitmap);
        this.f1578a.k = null;
        this.f1578a.c = bitmap;
        progressBar = this.f1578a.j;
        progressBar.setVisibility(8);
        if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
            imageView = this.f1578a.b;
            imageView.setImageBitmap(bitmap);
            if (Build.VERSION.SDK_INT >= 7) {
                z = this.f1578a.v;
                if (z) {
                    WriteImageActivity writeImageActivity = this.f1578a;
                    strArr = WriteImageActivity.f1551a;
                    writeImageActivity.a(strArr);
                }
            }
        }
    }
}
