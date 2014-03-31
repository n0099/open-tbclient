package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.plugins.MotuPlugin;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bn extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ WriteImageActivity a;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ Bitmap a(Object... objArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Bitmap bitmap) {
        TextView textView;
        ProgressBar progressBar;
        ImageView imageView;
        boolean z;
        String[] strArr;
        Bitmap bitmap2 = bitmap;
        super.a((bn) bitmap2);
        textView = this.a.d;
        textView.setEnabled(true);
        this.a.h = null;
        this.a.c = bitmap2;
        progressBar = this.a.g;
        progressBar.setVisibility(8);
        if (bitmap2 == null || bitmap2.isRecycled() || bitmap2 == null) {
            return;
        }
        imageView = this.a.b;
        imageView.setImageBitmap(bitmap2);
        if (Build.VERSION.SDK_INT >= 7) {
            z = this.a.u;
            if (z) {
                WriteImageActivity writeImageActivity = this.a;
                strArr = WriteImageActivity.a;
                WriteImageActivity.a(writeImageActivity, strArr);
            }
        }
    }

    private bn(WriteImageActivity writeImageActivity) {
        this.a = writeImageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bn(WriteImageActivity writeImageActivity, byte b) {
        this(writeImageActivity);
    }

    private Bitmap a() {
        Bitmap bitmap;
        Exception e;
        boolean z;
        Object obj;
        HashMap hashMap;
        String[] strArr;
        Bitmap createOneKeyFilterAndApply;
        Object obj2;
        HashMap hashMap2;
        try {
            bitmap = com.baidu.tbadk.core.util.w.c(null, "tieba_resized_image");
            try {
                if (isCancelled() && bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                    bitmap = null;
                } else if (bitmap != null) {
                    int a = com.baidu.adp.lib.util.i.a((Context) this.a, 63.5f);
                    if (Build.VERSION.SDK_INT >= 7) {
                        z = this.a.u;
                        if (z) {
                            Bitmap b = com.baidu.tbadk.core.util.g.b(bitmap, a);
                            if (b == null) {
                                return null;
                            }
                            Bitmap a2 = b.equals(bitmap) ? com.baidu.tbadk.core.util.g.a(com.baidu.tbadk.core.util.g.c(bitmap, 100)) : bitmap;
                            try {
                                Bitmap a3 = com.baidu.tbadk.core.util.g.a(b, com.baidu.adp.lib.util.i.a((Context) this.a, 5.0f), true);
                                if (a3 == null) {
                                    return null;
                                }
                                obj = this.a.D;
                                synchronized (obj) {
                                    this.a.B = new HashMap();
                                    this.a.C = new HashMap();
                                    hashMap = this.a.B;
                                    hashMap.put("normal", a3);
                                }
                                strArr = WriteImageActivity.a;
                                for (String str : strArr) {
                                    String substring = str.substring(0, str.indexOf("|"));
                                    if (!substring.equals("normal")) {
                                        Bitmap.Config config = a3.getConfig();
                                        Bitmap.Config config2 = config == null ? com.baidu.tbadk.core.data.n.b : config;
                                        MotuPlugin motuPlugin = (MotuPlugin) com.baidu.tbplugin.k.a().a(MotuPlugin.class);
                                        if (motuPlugin == null || (createOneKeyFilterAndApply = motuPlugin.createOneKeyFilterAndApply(this.a, substring, a3.copy(config2, true))) == null) {
                                            return null;
                                        }
                                        obj2 = this.a.D;
                                        synchronized (obj2) {
                                            hashMap2 = this.a.B;
                                            hashMap2.put(substring, createOneKeyFilterAndApply);
                                        }
                                    }
                                }
                                bitmap = a2;
                            } catch (Exception e2) {
                                e = e2;
                                bitmap = a2;
                                e.printStackTrace();
                                com.baidu.adp.lib.util.f.b(getClass().getName(), "GetImageTask", e.toString());
                                return bitmap;
                            }
                        }
                    }
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Exception e4) {
            bitmap = null;
            e = e4;
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        ProgressBar progressBar;
        TextView textView;
        progressBar = this.a.g;
        progressBar.setVisibility(0);
        textView = this.a.d;
        textView.setEnabled(false);
        super.c();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        ProgressBar progressBar;
        this.a.h = null;
        progressBar = this.a.g;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
