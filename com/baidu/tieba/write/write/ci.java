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
public class ci extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ WriteImageActivity this$0;

    private ci(WriteImageActivity writeImageActivity) {
        this.this$0 = writeImageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ci(WriteImageActivity writeImageActivity, ci ciVar) {
        this(writeImageActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: n */
    public Bitmap doInBackground(Object... objArr) {
        boolean z;
        Object obj;
        HashMap hashMap;
        Bitmap bitmap = null;
        try {
            Bitmap ac = com.baidu.tbadk.core.util.o.ac(null, TbConfig.IMAGE_RESIZED_FILE);
            try {
                if (isCancelled() && ac != null && !ac.isRecycled()) {
                    ac.recycle();
                    return null;
                }
                if (ac != null) {
                    int dip2px = com.baidu.adp.lib.util.n.dip2px(this.this$0.getPageContext().getPageActivity(), 63.5f);
                    if (Build.VERSION.SDK_INT >= 7) {
                        z = this.this$0.bRo;
                        if (z) {
                            Bitmap f = com.baidu.tbadk.core.util.c.f(ac, dip2px);
                            if (f != null) {
                                if (f.equals(ac)) {
                                    ac = com.baidu.tbadk.core.util.c.w(com.baidu.tbadk.core.util.c.e(ac, 100));
                                }
                                Bitmap a = com.baidu.tbadk.core.util.c.a(f, com.baidu.adp.lib.util.n.dip2px(this.this$0.getPageContext().getPageActivity(), 5.0f), true);
                                if (a != null) {
                                    obj = this.this$0.cDc;
                                    synchronized (obj) {
                                        this.this$0.bRs = new HashMap();
                                        this.this$0.bRt = new HashMap();
                                        hashMap = this.this$0.bRs;
                                        hashMap.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, a);
                                    }
                                    return ac;
                                }
                                return null;
                            }
                            return null;
                        }
                    }
                }
                return ac;
            } catch (Exception e) {
                bitmap = ac;
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
        view = this.this$0.cCX;
        view.setEnabled(false);
        super.onPreExecute();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.this$0.cCY = null;
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
        super.onPostExecute((ci) bitmap);
        view = this.this$0.cCX;
        view.setEnabled(true);
        this.this$0.cCY = null;
        this.this$0.mBitmap = bitmap;
        progressBar = this.this$0.mProgress;
        progressBar.setVisibility(8);
        if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
            imageView = this.this$0.avb;
            imageView.setImageBitmap(bitmap);
            if (Build.VERSION.SDK_INT >= 7) {
                z = this.this$0.bRo;
                if (z) {
                    WriteImageActivity writeImageActivity = this.this$0;
                    strArr = WriteImageActivity.bQW;
                    writeImageActivity.w(strArr);
                }
            }
        }
    }
}
