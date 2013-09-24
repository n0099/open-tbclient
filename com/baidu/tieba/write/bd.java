package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import cn.jingling.lib.filters.FilterFactory;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.UtilHelper;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd extends BdAsyncTask<Object, Integer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteImageActivity f2108a;

    private bd(WriteImageActivity writeImageActivity) {
        this.f2108a = writeImageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bd(WriteImageActivity writeImageActivity, bd bdVar) {
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
            c = com.baidu.tieba.util.p.c(null, "tieba_resized_image");
        } catch (Exception e) {
            e = e;
        }
        try {
            if (isCancelled() && c != null && !c.isRecycled()) {
                c.recycle();
                return null;
            }
            int a2 = UtilHelper.a((Context) this.f2108a, 63.5f);
            if (Build.VERSION.SDK_INT >= 7) {
                z = this.f2108a.v;
                if (z) {
                    Bitmap a3 = com.baidu.tieba.util.e.a(com.baidu.tieba.util.e.b(c, a2), UtilHelper.a((Context) this.f2108a, 5.0f));
                    this.f2108a.B = new HashMap();
                    this.f2108a.C = new HashMap();
                    hashMap = this.f2108a.B;
                    hashMap.put("normal", a3);
                    strArr = WriteImageActivity.f2076a;
                    for (String str : strArr) {
                        String substring = str.substring(0, str.indexOf("|"));
                        if (!substring.equals("normal")) {
                            Bitmap apply = FilterFactory.createOneKeyFilter(this.f2108a, substring).apply(this.f2108a, a3.copy(a3.getConfig(), true));
                            hashMap2 = this.f2108a.B;
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
            e.printStackTrace();
            com.baidu.tieba.util.av.b(getClass().getName(), "GetImageTask", e.toString());
            return bitmap;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        Button button;
        progressBar = this.f2108a.j;
        progressBar.setVisibility(0);
        button = this.f2108a.e;
        button.setClickable(false);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.f2108a.k = null;
        progressBar = this.f2108a.j;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Bitmap bitmap) {
        Button button;
        ProgressBar progressBar;
        ImageView imageView;
        boolean z;
        String[] strArr;
        super.a((bd) bitmap);
        button = this.f2108a.e;
        button.setClickable(true);
        this.f2108a.k = null;
        this.f2108a.c = bitmap;
        progressBar = this.f2108a.j;
        progressBar.setVisibility(8);
        if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
            imageView = this.f2108a.b;
            imageView.setImageBitmap(bitmap);
            if (Build.VERSION.SDK_INT >= 7) {
                z = this.f2108a.v;
                if (z) {
                    WriteImageActivity writeImageActivity = this.f2108a;
                    strArr = WriteImageActivity.f2076a;
                    writeImageActivity.a(strArr);
                }
            }
        }
    }
}
