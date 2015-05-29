package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.widget.EditHeadsImageView;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ EditHeadActivity this$0;

    private q(EditHeadActivity editHeadActivity) {
        this.this$0 = editHeadActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q(EditHeadActivity editHeadActivity, q qVar) {
        this(editHeadActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: n */
    public Bitmap doInBackground(Object... objArr) {
        boolean z;
        HashMap hashMap;
        Bitmap bitmap = null;
        try {
            Bitmap ac = com.baidu.tbadk.core.util.o.ac(null, TbConfig.IMAGE_RESIZED_FILE);
            try {
                if (ac.getWidth() > 750 || ac.getHeight() > 750) {
                    Bitmap d = com.baidu.tbadk.core.util.c.d(ac, TbConfig.POST_IMAGE_MIDDLE);
                    try {
                        ac.recycle();
                        ac = d;
                    } catch (Exception e) {
                        e = e;
                        bitmap = d;
                        BdLog.e(e.toString());
                        return bitmap;
                    }
                }
                if (isCancelled() && ac != null && !ac.isRecycled()) {
                    ac.recycle();
                    return null;
                }
                int dip2px = com.baidu.adp.lib.util.n.dip2px(this.this$0.getPageContext().getPageActivity(), 63.5f);
                if (Build.VERSION.SDK_INT >= 7) {
                    z = this.this$0.bRo;
                    if (z) {
                        Bitmap f = com.baidu.tbadk.core.util.c.f(ac, dip2px);
                        Bitmap a = com.baidu.tbadk.core.util.c.a(f, com.baidu.adp.lib.util.n.dip2px(this.this$0.getPageContext().getPageActivity(), 5.0f), ac != f);
                        this.this$0.bRs = new HashMap();
                        this.this$0.bRt = new HashMap();
                        hashMap = this.this$0.bRs;
                        hashMap.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, a);
                        return ac;
                    }
                }
                return ac;
            } catch (Exception e2) {
                bitmap = ac;
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        View view;
        progressBar = this.this$0.mProgress;
        progressBar.setVisibility(0);
        view = this.this$0.bQZ;
        view.setClickable(false);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        View view;
        View view2;
        this.this$0.bRd = null;
        progressBar = this.this$0.mProgress;
        progressBar.setVisibility(8);
        view = this.this$0.bQZ;
        view.setClickable(true);
        view2 = this.this$0.bQZ;
        view2.setEnabled(true);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        View view;
        View view2;
        EditHeadsImageView editHeadsImageView;
        EditHeadsImageView editHeadsImageView2;
        boolean z;
        String[] strArr;
        super.onPostExecute((q) bitmap);
        this.this$0.bRd = null;
        this.this$0.mBitmap = bitmap;
        progressBar = this.this$0.mProgress;
        progressBar.setVisibility(8);
        view = this.this$0.bQZ;
        view.setClickable(true);
        view2 = this.this$0.bQZ;
        view2.setEnabled(true);
        if (bitmap == null || bitmap.isRecycled()) {
            editHeadsImageView = this.this$0.bQX;
            editHeadsImageView.setImageDrawable(null);
        } else if (bitmap != null) {
            editHeadsImageView2 = this.this$0.bQX;
            editHeadsImageView2.setImageBitmap(bitmap);
            if (Build.VERSION.SDK_INT >= 7) {
                z = this.this$0.bRo;
                if (z) {
                    EditHeadActivity editHeadActivity = this.this$0;
                    strArr = EditHeadActivity.bQW;
                    editHeadActivity.w(strArr);
                }
            }
        }
    }
}
