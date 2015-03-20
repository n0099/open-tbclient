package com.baidu.tieba.write.write;

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
public class ch extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ WriteImageActivity this$0;

    private ch(WriteImageActivity writeImageActivity) {
        this.this$0 = writeImageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ch(WriteImageActivity writeImageActivity, ch chVar) {
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
            Bitmap Y = com.baidu.tbadk.core.util.o.Y(null, TbConfig.IMAGE_RESIZED_FILE);
            try {
                if (isCancelled() && Y != null && !Y.isRecycled()) {
                    Y.recycle();
                    return null;
                }
                if (Y != null) {
                    int dip2px = com.baidu.adp.lib.util.n.dip2px(this.this$0.getPageContext().getPageActivity(), 63.5f);
                    if (Build.VERSION.SDK_INT >= 7) {
                        z = this.this$0.bOV;
                        if (z) {
                            Bitmap f = com.baidu.tbadk.core.util.c.f(Y, dip2px);
                            if (f != null) {
                                if (f.equals(Y)) {
                                    Y = com.baidu.tbadk.core.util.c.w(com.baidu.tbadk.core.util.c.e(Y, 100));
                                }
                                Bitmap a = com.baidu.tbadk.core.util.c.a(f, com.baidu.adp.lib.util.n.dip2px(this.this$0.getPageContext().getPageActivity(), 5.0f), true);
                                if (a != null) {
                                    obj = this.this$0.cyo;
                                    synchronized (obj) {
                                        this.this$0.bOZ = new HashMap();
                                        this.this$0.bPa = new HashMap();
                                        hashMap = this.this$0.bOZ;
                                        hashMap.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, a);
                                    }
                                    return Y;
                                }
                                return null;
                            }
                            return null;
                        }
                    }
                }
                return Y;
            } catch (Exception e) {
                bitmap = Y;
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
        view = this.this$0.cyj;
        view.setEnabled(false);
        super.onPreExecute();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.this$0.cyk = null;
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
        super.onPostExecute((ch) bitmap);
        view = this.this$0.cyj;
        view.setEnabled(true);
        this.this$0.cyk = null;
        this.this$0.mBitmap = bitmap;
        progressBar = this.this$0.mProgress;
        progressBar.setVisibility(8);
        if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
            imageView = this.this$0.atv;
            imageView.setImageBitmap(bitmap);
            if (Build.VERSION.SDK_INT >= 7) {
                z = this.this$0.bOV;
                if (z) {
                    WriteImageActivity writeImageActivity = this.this$0;
                    strArr = WriteImageActivity.bOD;
                    writeImageActivity.v(strArr);
                }
            }
        }
    }
}
