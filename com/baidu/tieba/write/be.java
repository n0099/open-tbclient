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
public class be extends BdAsyncTask<Object, Integer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteImageActivity f2653a;

    private be(WriteImageActivity writeImageActivity) {
        this.f2653a = writeImageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ be(WriteImageActivity writeImageActivity, av avVar) {
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
            c = com.baidu.tieba.util.w.c(null, "tieba_resized_image");
        } catch (Exception e) {
            e = e;
        }
        try {
            if (isCancelled() && c != null && !c.isRecycled()) {
                c.recycle();
                return null;
            }
            if (c != null) {
                int a2 = UtilHelper.a((Context) this.f2653a, 63.5f);
                if (Build.VERSION.SDK_INT >= 7) {
                    z = this.f2653a.w;
                    if (z) {
                        Bitmap b = com.baidu.tieba.util.e.b(c, a2);
                        if (b == null) {
                            return null;
                        }
                        if (b.equals(c)) {
                            c = com.baidu.tieba.util.e.a(com.baidu.tieba.util.e.c(c, 100));
                        }
                        Bitmap a3 = com.baidu.tieba.util.e.a(b, UtilHelper.a((Context) this.f2653a, 5.0f));
                        if (a3 == null) {
                            return null;
                        }
                        obj = this.f2653a.G;
                        synchronized (obj) {
                            this.f2653a.E = new HashMap();
                            this.f2653a.F = new HashMap();
                            hashMap = this.f2653a.E;
                            hashMap.put("normal", a3);
                        }
                        strArr = WriteImageActivity.f2620a;
                        for (String str : strArr) {
                            String substring = str.substring(0, str.indexOf("|"));
                            if (!substring.equals("normal")) {
                                Bitmap.Config config = a3.getConfig();
                                if (config == null) {
                                    config = com.baidu.tieba.data.h.m;
                                }
                                Bitmap apply = FilterFactory.createOneKeyFilter(this.f2653a, substring).apply(this.f2653a, a3.copy(config, true));
                                if (apply == null) {
                                    return null;
                                }
                                obj2 = this.f2653a.G;
                                synchronized (obj2) {
                                    hashMap2 = this.f2653a.E;
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
            com.baidu.tieba.util.be.b(getClass().getName(), "GetImageTask", e.toString());
            return bitmap;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        Button button;
        progressBar = this.f2653a.j;
        progressBar.setVisibility(0);
        button = this.f2653a.e;
        button.setClickable(false);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.f2653a.k = null;
        progressBar = this.f2653a.j;
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
        super.a((be) bitmap);
        button = this.f2653a.e;
        button.setClickable(true);
        this.f2653a.k = null;
        this.f2653a.c = bitmap;
        progressBar = this.f2653a.j;
        progressBar.setVisibility(8);
        if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
            imageView = this.f2653a.b;
            imageView.setImageBitmap(bitmap);
            if (Build.VERSION.SDK_INT >= 7) {
                z = this.f2653a.w;
                if (z) {
                    WriteImageActivity writeImageActivity = this.f2653a;
                    strArr = WriteImageActivity.f2620a;
                    writeImageActivity.a(strArr);
                }
            }
        }
    }
}
