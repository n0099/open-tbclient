package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import cn.jingling.lib.filters.FilterFactory;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.cloudsdk.social.core.SocialConstants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av extends BdAsyncTask<String, Void, Bitmap> {
    final /* synthetic */ WriteImageActivity a;
    private String b;
    private Bitmap c;
    private Boolean d;
    private Boolean e;

    private av(WriteImageActivity writeImageActivity) {
        this.a = writeImageActivity;
        this.d = false;
        this.e = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ av(WriteImageActivity writeImageActivity, an anVar) {
        this(writeImageActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        TextView textView;
        progressBar = this.a.g;
        progressBar.setVisibility(0);
        textView = this.a.e;
        textView.setClickable(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Bitmap a(String... strArr) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap bitmap4;
        Bitmap bitmap5;
        Bitmap bitmap6;
        Bitmap bitmap7;
        Bitmap bitmap8;
        Bitmap bitmap9;
        Bitmap bitmap10;
        Bitmap bitmap11;
        Bitmap bitmap12;
        this.b = strArr[0];
        bitmap = this.a.c;
        if (bitmap == null) {
            bitmap12 = this.a.p;
            if (bitmap12 == null) {
                return null;
            }
        }
        if (this.b.equals(SocialConstants.FALSE) || this.b.equals(SocialConstants.TRUE)) {
            this.d = true;
        } else if (this.b.equals("2") || this.b.equals("3")) {
            this.e = true;
        }
        if (this.d.booleanValue() || this.e.booleanValue()) {
            bitmap2 = this.a.p;
            if (bitmap2 != null) {
                bitmap6 = this.a.p;
                if (!bitmap6.isRecycled()) {
                    bitmap7 = this.a.p;
                    bitmap8 = this.a.p;
                    this.c = bitmap7.copy(bitmap8.getConfig(), true);
                }
            }
            bitmap3 = this.a.c;
            if (!bitmap3.isRecycled()) {
                bitmap4 = this.a.c;
                bitmap5 = this.a.c;
                this.c = bitmap4.copy(bitmap5.getConfig(), true);
            }
        } else {
            bitmap9 = this.a.c;
            if (!bitmap9.isRecycled()) {
                bitmap10 = this.a.c;
                bitmap11 = this.a.c;
                this.c = bitmap10.copy(bitmap11.getConfig(), true);
            }
        }
        if (this.c != null) {
            if (this.c.getWidth() > 900 || this.c.getHeight() > 900) {
                this.c = com.baidu.tieba.util.m.a(this.c, (int) BdWebErrorView.ERROR_CODE_900);
            }
            if (this.d.booleanValue()) {
                this.c = com.baidu.tieba.util.m.d(this.c, Integer.parseInt(this.b));
            } else if (this.e.booleanValue()) {
                this.c = com.baidu.tieba.util.m.f(this.c, Integer.parseInt(this.b));
            } else {
                this.c = FilterFactory.createOneKeyFilter(this.a, this.b).apply(this.a, this.c);
            }
            return this.c;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        TextView textView;
        Bitmap bitmap;
        if (this.c != null && !this.c.isRecycled()) {
            bitmap = this.a.p;
            if (bitmap != this.c) {
                this.c.recycle();
            }
        }
        this.c = null;
        progressBar = this.a.g;
        progressBar.setVisibility(8);
        textView = this.a.e;
        textView.setClickable(true);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005b, code lost:
        if (r0.getHeight() > 900) goto L21;
     */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Bitmap bitmap) {
        ProgressBar progressBar;
        TextView textView;
        ImageView imageView;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap bitmap4;
        Bitmap bitmap5;
        Bitmap bitmap6;
        Bitmap bitmap7;
        Bitmap bitmap8;
        Bitmap bitmap9;
        Bitmap bitmap10;
        progressBar = this.a.g;
        progressBar.setVisibility(8);
        textView = this.a.e;
        textView.setClickable(true);
        if (bitmap != null && !bitmap.isRecycled()) {
            this.a.x = true;
            imageView = this.a.b;
            imageView.setImageBitmap(bitmap);
            bitmap2 = this.a.c;
            if (bitmap2 != null && (this.d.booleanValue() || this.e.booleanValue())) {
                bitmap6 = this.a.c;
                if (bitmap6.getWidth() <= 900) {
                    bitmap10 = this.a.c;
                }
                WriteImageActivity writeImageActivity = this.a;
                bitmap7 = this.a.c;
                writeImageActivity.c = com.baidu.tieba.util.m.a(bitmap7, (int) BdWebErrorView.ERROR_CODE_900);
                if (this.d.booleanValue()) {
                    WriteImageActivity writeImageActivity2 = this.a;
                    bitmap9 = this.a.c;
                    writeImageActivity2.c = com.baidu.tieba.util.m.d(bitmap9, Integer.parseInt(this.b));
                } else if (this.e.booleanValue()) {
                    WriteImageActivity writeImageActivity3 = this.a;
                    bitmap8 = this.a.c;
                    writeImageActivity3.c = com.baidu.tieba.util.m.f(bitmap8, Integer.parseInt(this.b));
                }
            }
            bitmap3 = this.a.p;
            if (bitmap3 != null) {
                bitmap4 = this.a.p;
                if (!bitmap4.isRecycled()) {
                    bitmap5 = this.a.p;
                    bitmap5.recycle();
                }
            }
            this.a.p = bitmap;
        }
    }
}
