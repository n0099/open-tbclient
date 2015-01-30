package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
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
    /* renamed from: k */
    public Bitmap doInBackground(Object... objArr) {
        boolean z;
        Object obj;
        HashMap hashMap;
        Bitmap bitmap = null;
        try {
            Bitmap X = com.baidu.tbadk.core.util.s.X(null, TbConfig.IMAGE_RESIZED_FILE);
            try {
                if (isCancelled() && X != null && !X.isRecycled()) {
                    X.recycle();
                    return null;
                }
                if (X != null) {
                    int dip2px = com.baidu.adp.lib.util.l.dip2px(this.this$0.getPageContext().getPageActivity(), 63.5f);
                    if (Build.VERSION.SDK_INT >= 7) {
                        z = this.this$0.PE;
                        if (z) {
                            Bitmap f = com.baidu.tbadk.core.util.d.f(X, dip2px);
                            if (f != null) {
                                if (f.equals(X)) {
                                    X = com.baidu.tbadk.core.util.d.v(com.baidu.tbadk.core.util.d.e(X, 100));
                                }
                                Bitmap a = com.baidu.tbadk.core.util.d.a(f, com.baidu.adp.lib.util.l.dip2px(this.this$0.getPageContext().getPageActivity(), 5.0f), true);
                                if (a != null) {
                                    obj = this.this$0.chf;
                                    synchronized (obj) {
                                        this.this$0.PJ = new HashMap();
                                        this.this$0.PK = new HashMap();
                                        hashMap = this.this$0.PJ;
                                        hashMap.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, a);
                                    }
                                    return X;
                                }
                                return null;
                            }
                            return null;
                        }
                    }
                }
                return X;
            } catch (Exception e) {
                bitmap = X;
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
        View view;
        progressBar = this.this$0.mProgress;
        progressBar.setVisibility(0);
        view = this.this$0.cha;
        view.setEnabled(false);
        super.onPreExecute();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.this$0.chb = null;
        progressBar = this.this$0.mProgress;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Bitmap bitmap) {
        View view;
        ProgressBar progressBar;
        ImageView imageView;
        boolean z;
        String[] strArr;
        super.onPostExecute((cc) bitmap);
        view = this.this$0.cha;
        view.setEnabled(true);
        this.this$0.chb = null;
        this.this$0.mBitmap = bitmap;
        progressBar = this.this$0.mProgress;
        progressBar.setVisibility(8);
        if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
            imageView = this.this$0.anr;
            imageView.setImageBitmap(bitmap);
            if (Build.VERSION.SDK_INT >= 7) {
                z = this.this$0.PE;
                if (z) {
                    WriteImageActivity writeImageActivity = this.this$0;
                    strArr = WriteImageActivity.Pk;
                    writeImageActivity.m(strArr);
                }
            }
        }
    }
}
