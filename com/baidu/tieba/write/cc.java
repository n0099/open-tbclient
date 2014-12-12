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
            Bitmap U = com.baidu.tbadk.core.util.s.U(null, TbConfig.IMAGE_RESIZED_FILE);
            try {
                if (isCancelled() && U != null && !U.isRecycled()) {
                    U.recycle();
                    return null;
                }
                if (U != null) {
                    int dip2px = com.baidu.adp.lib.util.l.dip2px(this.this$0.getPageContext().getPageActivity(), 63.5f);
                    if (Build.VERSION.SDK_INT >= 7) {
                        z = this.this$0.Pd;
                        if (z) {
                            Bitmap f = com.baidu.tbadk.core.util.d.f(U, dip2px);
                            if (f != null) {
                                if (f.equals(U)) {
                                    U = com.baidu.tbadk.core.util.d.v(com.baidu.tbadk.core.util.d.e(U, 100));
                                }
                                Bitmap a = com.baidu.tbadk.core.util.d.a(f, com.baidu.adp.lib.util.l.dip2px(this.this$0.getPageContext().getPageActivity(), 5.0f), true);
                                if (a != null) {
                                    obj = this.this$0.cfF;
                                    synchronized (obj) {
                                        this.this$0.Ph = new HashMap();
                                        this.this$0.Pi = new HashMap();
                                        hashMap = this.this$0.Ph;
                                        hashMap.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, a);
                                    }
                                    return U;
                                }
                                return null;
                            }
                            return null;
                        }
                    }
                }
                return U;
            } catch (Exception e) {
                bitmap = U;
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
        view = this.this$0.cfA;
        view.setEnabled(false);
        super.onPreExecute();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.this$0.cfB = null;
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
        view = this.this$0.cfA;
        view.setEnabled(true);
        this.this$0.cfB = null;
        this.this$0.mBitmap = bitmap;
        progressBar = this.this$0.mProgress;
        progressBar.setVisibility(8);
        if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
            imageView = this.this$0.akv;
            imageView.setImageBitmap(bitmap);
            if (Build.VERSION.SDK_INT >= 7) {
                z = this.this$0.Pd;
                if (z) {
                    WriteImageActivity writeImageActivity = this.this$0;
                    strArr = WriteImageActivity.OG;
                    writeImageActivity.m(strArr);
                }
            }
        }
    }
}
