package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import cn.jingling.lib.filters.FilterFactory;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ WriteImageActivity a;

    private aw(WriteImageActivity writeImageActivity) {
        this.a = writeImageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aw(WriteImageActivity writeImageActivity, an anVar) {
        this(writeImageActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Bitmap a(Object... objArr) {
        Bitmap c;
        boolean z;
        Object obj;
        HashMap hashMap;
        String[] strArr;
        Object obj2;
        HashMap hashMap2;
        Bitmap bitmap = null;
        try {
            c = com.baidu.tieba.util.ad.c(null, "tieba_resized_image");
        } catch (Exception e) {
            e = e;
        }
        try {
            if (isCancelled() && c != null && !c.isRecycled()) {
                c.recycle();
                return null;
            }
            if (c != null) {
                int a = com.baidu.adp.lib.g.g.a((Context) this.a, 63.5f);
                if (Build.VERSION.SDK_INT >= 7) {
                    z = this.a.t;
                    if (z) {
                        Bitmap b = com.baidu.tieba.util.n.b(c, a);
                        if (b == null) {
                            return null;
                        }
                        if (b.equals(c)) {
                            c = com.baidu.tieba.util.n.a(com.baidu.tieba.util.n.c(c, 100));
                        }
                        Bitmap a2 = com.baidu.tieba.util.n.a(b, com.baidu.adp.lib.g.g.a((Context) this.a, 5.0f));
                        if (a2 == null) {
                            return null;
                        }
                        obj = this.a.C;
                        synchronized (obj) {
                            this.a.A = new HashMap();
                            this.a.B = new HashMap();
                            hashMap = this.a.A;
                            hashMap.put("normal", a2);
                        }
                        strArr = WriteImageActivity.a;
                        for (String str : strArr) {
                            String substring = str.substring(0, str.indexOf("|"));
                            if (!substring.equals("normal")) {
                                Bitmap.Config config = a2.getConfig();
                                if (config == null) {
                                    config = com.baidu.tieba.data.h.m;
                                }
                                Bitmap apply = FilterFactory.createOneKeyFilter(this.a, substring).apply(this.a, a2.copy(config, true));
                                if (apply == null) {
                                    return null;
                                }
                                obj2 = this.a.C;
                                synchronized (obj2) {
                                    hashMap2 = this.a.A;
                                    hashMap2.put(substring, apply);
                                }
                            }
                        }
                    }
                }
            }
            return c;
        } catch (Exception e2) {
            bitmap = c;
            e = e2;
            e.printStackTrace();
            com.baidu.adp.lib.g.e.b(getClass().getName(), "GetImageTask", e.toString());
            return bitmap;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        TextView textView;
        progressBar = this.a.f;
        progressBar.setVisibility(0);
        textView = this.a.d;
        textView.setClickable(false);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.a.g = null;
        progressBar = this.a.f;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Bitmap bitmap) {
        TextView textView;
        ProgressBar progressBar;
        ImageView imageView;
        boolean z;
        String[] strArr;
        super.a((aw) bitmap);
        textView = this.a.d;
        textView.setClickable(true);
        this.a.g = null;
        this.a.c = bitmap;
        progressBar = this.a.f;
        progressBar.setVisibility(8);
        if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
            imageView = this.a.b;
            imageView.setImageBitmap(bitmap);
            if (Build.VERSION.SDK_INT >= 7) {
                z = this.a.t;
                if (z) {
                    WriteImageActivity writeImageActivity = this.a;
                    strArr = WriteImageActivity.a;
                    writeImageActivity.a(strArr);
                }
            }
        }
    }
}
