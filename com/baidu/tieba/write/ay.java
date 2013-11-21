package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import cn.jingling.lib.filters.FilterFactory;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.bg;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends BdAsyncTask<Object, Integer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteImageActivity f2681a;

    private ay(WriteImageActivity writeImageActivity) {
        this.f2681a = writeImageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ay(WriteImageActivity writeImageActivity, ap apVar) {
        this(writeImageActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Bitmap a(Object... objArr) {
        Bitmap d;
        boolean z;
        Object obj;
        HashMap hashMap;
        String[] strArr;
        Object obj2;
        HashMap hashMap2;
        Bitmap bitmap = null;
        try {
            d = com.baidu.tieba.util.af.d(null, "tieba_resized_image");
        } catch (Exception e) {
            e = e;
        }
        try {
            if (isCancelled() && d != null && !d.isRecycled()) {
                d.recycle();
                return null;
            }
            if (d != null) {
                int a2 = UtilHelper.a((Context) this.f2681a, 63.5f);
                if (Build.VERSION.SDK_INT >= 7) {
                    z = this.f2681a.u;
                    if (z) {
                        Bitmap b = com.baidu.tieba.util.m.b(d, a2);
                        if (b == null) {
                            return null;
                        }
                        if (b.equals(d)) {
                            d = com.baidu.tieba.util.m.a(com.baidu.tieba.util.m.c(d, 100));
                        }
                        Bitmap a3 = com.baidu.tieba.util.m.a(b, UtilHelper.a((Context) this.f2681a, 5.0f));
                        if (a3 == null) {
                            return null;
                        }
                        obj = this.f2681a.E;
                        synchronized (obj) {
                            this.f2681a.C = new HashMap();
                            this.f2681a.D = new HashMap();
                            hashMap = this.f2681a.C;
                            hashMap.put("normal", a3);
                        }
                        strArr = WriteImageActivity.f2654a;
                        for (String str : strArr) {
                            String substring = str.substring(0, str.indexOf("|"));
                            if (!substring.equals("normal")) {
                                Bitmap.Config config = a3.getConfig();
                                if (config == null) {
                                    config = com.baidu.tieba.data.h.n;
                                }
                                Bitmap apply = FilterFactory.createOneKeyFilter(this.f2681a, substring).apply(this.f2681a, a3.copy(config, true));
                                if (apply == null) {
                                    return null;
                                }
                                obj2 = this.f2681a.E;
                                synchronized (obj2) {
                                    hashMap2 = this.f2681a.C;
                                    hashMap2.put(substring, apply);
                                }
                            }
                        }
                    }
                }
            }
            return d;
        } catch (Exception e2) {
            bitmap = d;
            e = e2;
            e.printStackTrace();
            bg.b(getClass().getName(), "GetImageTask", e.toString());
            return bitmap;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        TextView textView;
        progressBar = this.f2681a.g;
        progressBar.setVisibility(0);
        textView = this.f2681a.e;
        textView.setClickable(false);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.f2681a.h = null;
        progressBar = this.f2681a.g;
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
        super.a((ay) bitmap);
        textView = this.f2681a.e;
        textView.setClickable(true);
        this.f2681a.h = null;
        this.f2681a.c = bitmap;
        progressBar = this.f2681a.g;
        progressBar.setVisibility(8);
        if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
            imageView = this.f2681a.b;
            imageView.setImageBitmap(bitmap);
            if (Build.VERSION.SDK_INT >= 7) {
                z = this.f2681a.u;
                if (z) {
                    WriteImageActivity writeImageActivity = this.f2681a;
                    strArr = WriteImageActivity.f2654a;
                    writeImageActivity.a(strArr);
                }
            }
        }
    }
}
