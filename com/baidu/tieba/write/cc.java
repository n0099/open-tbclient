package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.os.Build;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ WriteImageActivity this$0;

    private cc(WriteImageActivity writeImageActivity) {
        this.this$0 = writeImageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ cc(WriteImageActivity writeImageActivity, cc ccVar) {
        this(writeImageActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: g */
    public Bitmap doInBackground(Object... objArr) {
        boolean z;
        Object obj;
        HashMap hashMap;
        Bitmap bitmap = null;
        try {
            Bitmap K = com.baidu.tbadk.core.util.s.K(null, TbConfig.IMAGE_RESIZED_FILE);
            try {
                if (isCancelled() && K != null && !K.isRecycled()) {
                    K.recycle();
                    return null;
                }
                if (K != null) {
                    int dip2px = com.baidu.adp.lib.util.m.dip2px(this.this$0, 63.5f);
                    if (Build.VERSION.SDK_INT >= 7) {
                        z = this.this$0.JS;
                        if (z) {
                            Bitmap c = com.baidu.tbadk.core.util.d.c(K, dip2px);
                            if (c != null) {
                                if (c.equals(K)) {
                                    K = com.baidu.tbadk.core.util.d.w(com.baidu.tbadk.core.util.d.b(K, 100));
                                }
                                Bitmap a = com.baidu.tbadk.core.util.d.a(c, com.baidu.adp.lib.util.m.dip2px(this.this$0, 5.0f), true);
                                if (a != null) {
                                    obj = this.this$0.bUw;
                                    synchronized (obj) {
                                        this.this$0.JX = new HashMap();
                                        this.this$0.JY = new HashMap();
                                        hashMap = this.this$0.JX;
                                        hashMap.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, a);
                                    }
                                    return K;
                                }
                                return null;
                            }
                            return null;
                        }
                    }
                }
                return K;
            } catch (Exception e) {
                bitmap = K;
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
        progressBar = this.this$0.mProgress;
        progressBar.setVisibility(0);
        textView = this.this$0.bSH;
        textView.setEnabled(false);
        super.onPreExecute();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.this$0.bUs = null;
        progressBar = this.this$0.mProgress;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    public void onPostExecute(Bitmap bitmap) {
        TextView textView;
        ProgressBar progressBar;
        ImageView imageView;
        boolean z;
        String[] strArr;
        super.onPostExecute(bitmap);
        textView = this.this$0.bSH;
        textView.setEnabled(true);
        this.this$0.bUs = null;
        this.this$0.mBitmap = bitmap;
        progressBar = this.this$0.mProgress;
        progressBar.setVisibility(8);
        if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
            imageView = this.this$0.acK;
            imageView.setImageBitmap(bitmap);
            if (Build.VERSION.SDK_INT >= 7) {
                z = this.this$0.JS;
                if (z) {
                    WriteImageActivity writeImageActivity = this.this$0;
                    strArr = WriteImageActivity.Jz;
                    writeImageActivity.i(strArr);
                }
            }
        }
    }
}
