package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ WriteImageActivity a;

    private bu(WriteImageActivity writeImageActivity) {
        this.a = writeImageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bu(WriteImageActivity writeImageActivity, bu buVar) {
        this(writeImageActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Bitmap doInBackground(Object... objArr) {
        boolean z;
        Object obj;
        HashMap hashMap;
        Bitmap bitmap = null;
        try {
            Bitmap c = com.baidu.tbadk.core.util.s.c(null, TbConfig.IMAGE_RESIZED_FILE);
            try {
                if (isCancelled() && c != null && !c.isRecycled()) {
                    c.recycle();
                    return null;
                }
                if (c != null) {
                    int a = com.baidu.adp.lib.util.j.a((Context) this.a, 63.5f);
                    if (Build.VERSION.SDK_INT >= 7) {
                        z = this.a.v;
                        if (z) {
                            Bitmap b = com.baidu.tbadk.core.util.d.b(c, a);
                            if (b != null) {
                                if (b.equals(c)) {
                                    c = com.baidu.tbadk.core.util.d.a(com.baidu.tbadk.core.util.d.c(c, 100));
                                }
                                Bitmap a2 = com.baidu.tbadk.core.util.d.a(b, com.baidu.adp.lib.util.j.a((Context) this.a, 5.0f), true);
                                if (a2 != null) {
                                    obj = this.a.F;
                                    synchronized (obj) {
                                        this.a.D = new HashMap();
                                        this.a.E = new HashMap();
                                        hashMap = this.a.D;
                                        hashMap.put("normal", a2);
                                    }
                                    return c;
                                }
                                return null;
                            }
                            return null;
                        }
                    }
                }
                return c;
            } catch (Exception e) {
                bitmap = c;
                e = e;
                e.printStackTrace();
                BdLog.e(e.toString());
                return bitmap;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        TextView textView;
        progressBar = this.a.g;
        progressBar.setVisibility(0);
        textView = this.a.d;
        textView.setEnabled(false);
        super.onPreExecute();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.a.h = null;
        progressBar = this.a.g;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(Bitmap bitmap) {
        TextView textView;
        ProgressBar progressBar;
        ImageView imageView;
        boolean z;
        String[] strArr;
        super.onPostExecute(bitmap);
        textView = this.a.d;
        textView.setEnabled(true);
        this.a.h = null;
        this.a.c = bitmap;
        progressBar = this.a.g;
        progressBar.setVisibility(8);
        if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
            imageView = this.a.b;
            imageView.setImageBitmap(bitmap);
            if (Build.VERSION.SDK_INT >= 7) {
                z = this.a.v;
                if (z) {
                    WriteImageActivity writeImageActivity = this.a;
                    strArr = WriteImageActivity.a;
                    writeImageActivity.a(strArr);
                }
            }
        }
    }
}
