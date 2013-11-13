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
public class ax extends BdAsyncTask<Object, Integer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteImageActivity f2697a;

    private ax(WriteImageActivity writeImageActivity) {
        this.f2697a = writeImageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ax(WriteImageActivity writeImageActivity, ao aoVar) {
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
            c = com.baidu.tieba.util.af.c(null, "tieba_resized_image");
        } catch (Exception e) {
            e = e;
        }
        try {
            if (isCancelled() && c != null && !c.isRecycled()) {
                c.recycle();
                return null;
            }
            if (c != null) {
                int a2 = UtilHelper.a((Context) this.f2697a, 63.5f);
                if (Build.VERSION.SDK_INT >= 7) {
                    z = this.f2697a.u;
                    if (z) {
                        Bitmap b = com.baidu.tieba.util.m.b(c, a2);
                        if (b == null) {
                            return null;
                        }
                        if (b.equals(c)) {
                            c = com.baidu.tieba.util.m.a(com.baidu.tieba.util.m.c(c, 100));
                        }
                        Bitmap a3 = com.baidu.tieba.util.m.a(b, UtilHelper.a((Context) this.f2697a, 5.0f));
                        if (a3 == null) {
                            return null;
                        }
                        obj = this.f2697a.E;
                        synchronized (obj) {
                            this.f2697a.C = new HashMap();
                            this.f2697a.D = new HashMap();
                            hashMap = this.f2697a.C;
                            hashMap.put("normal", a3);
                        }
                        strArr = WriteImageActivity.f2671a;
                        for (String str : strArr) {
                            String substring = str.substring(0, str.indexOf("|"));
                            if (!substring.equals("normal")) {
                                Bitmap.Config config = a3.getConfig();
                                if (config == null) {
                                    config = com.baidu.tieba.data.h.n;
                                }
                                Bitmap apply = FilterFactory.createOneKeyFilter(this.f2697a, substring).apply(this.f2697a, a3.copy(config, true));
                                if (apply == null) {
                                    return null;
                                }
                                obj2 = this.f2697a.E;
                                synchronized (obj2) {
                                    hashMap2 = this.f2697a.C;
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
            bg.b(getClass().getName(), "GetImageTask", e.toString());
            return bitmap;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        TextView textView;
        progressBar = this.f2697a.g;
        progressBar.setVisibility(0);
        textView = this.f2697a.e;
        textView.setClickable(false);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.f2697a.h = null;
        progressBar = this.f2697a.g;
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
        super.a((ax) bitmap);
        textView = this.f2697a.e;
        textView.setClickable(true);
        this.f2697a.h = null;
        this.f2697a.c = bitmap;
        progressBar = this.f2697a.g;
        progressBar.setVisibility(8);
        if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
            imageView = this.f2697a.b;
            imageView.setImageBitmap(bitmap);
            if (Build.VERSION.SDK_INT >= 7) {
                z = this.f2697a.u;
                if (z) {
                    WriteImageActivity writeImageActivity = this.f2697a;
                    strArr = WriteImageActivity.f2671a;
                    writeImageActivity.a(strArr);
                }
            }
        }
    }
}
