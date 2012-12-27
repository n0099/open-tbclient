package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Build;
import android.widget.ImageView;
import android.widget.ProgressBar;
import cn.jingling.lib.filters.FilterFactory;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends AsyncTask {
    final /* synthetic */ WriteImageActivity a;

    private ay(WriteImageActivity writeImageActivity) {
        this.a = writeImageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ay(WriteImageActivity writeImageActivity, ay ayVar) {
        this(writeImageActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Bitmap doInBackground(Object... objArr) {
        Bitmap c;
        boolean z;
        HashMap hashMap;
        String[] strArr;
        HashMap hashMap2;
        Bitmap bitmap = null;
        try {
            c = com.baidu.tieba.c.o.c(null, "tieba_resized_image");
        } catch (Exception e) {
            e = e;
        }
        try {
            if (isCancelled() && c != null && !c.isRecycled()) {
                c.recycle();
                return null;
            }
            int a = com.baidu.tieba.c.ag.a((Context) this.a, 63.5f);
            if (Build.VERSION.SDK_INT >= 7) {
                z = this.a.u;
                if (z) {
                    Bitmap a2 = com.baidu.tieba.c.e.a(com.baidu.tieba.c.e.b(c, a), com.baidu.tieba.c.ag.a((Context) this.a, 5.0f));
                    this.a.A = new HashMap();
                    this.a.B = new HashMap();
                    hashMap = this.a.A;
                    hashMap.put("normal", a2);
                    strArr = WriteImageActivity.b;
                    for (String str : strArr) {
                        String substring = str.substring(0, str.indexOf("|"));
                        if (!substring.equals("normal")) {
                            Bitmap apply = FilterFactory.createOneKeyFilter(this.a, substring).apply(this.a, a2.copy(a2.getConfig(), true));
                            hashMap2 = this.a.A;
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
            com.baidu.tieba.c.ae.b(getClass().getName(), "GetImageTask", e.toString());
            return bitmap;
        }
    }

    public void a() {
        ProgressBar progressBar;
        this.a.j = null;
        progressBar = this.a.i;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        ImageView imageView;
        boolean z;
        String[] strArr;
        super.onPostExecute(bitmap);
        this.a.j = null;
        this.a.d = bitmap;
        progressBar = this.a.i;
        progressBar.setVisibility(8);
        if (bitmap == null || bitmap.isRecycled() || bitmap == null) {
            return;
        }
        imageView = this.a.c;
        imageView.setImageBitmap(bitmap);
        if (Build.VERSION.SDK_INT >= 7) {
            z = this.a.u;
            if (z) {
                WriteImageActivity writeImageActivity = this.a;
                strArr = WriteImageActivity.b;
                writeImageActivity.a(strArr);
            }
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.a.i;
        progressBar.setVisibility(0);
        super.onPreExecute();
    }
}
