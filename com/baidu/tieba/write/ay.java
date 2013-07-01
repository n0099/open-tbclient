package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import cn.jingling.lib.filters.FilterFactory;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteImageActivity f1577a;
    private String b;
    private Bitmap c;
    private Boolean d;
    private Boolean e;

    private ay(WriteImageActivity writeImageActivity) {
        this.f1577a = writeImageActivity;
        this.d = false;
        this.e = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ay(WriteImageActivity writeImageActivity, ay ayVar) {
        this(writeImageActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        Button button;
        progressBar = this.f1577a.j;
        progressBar.setVisibility(0);
        button = this.f1577a.e;
        button.setClickable(false);
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
        bitmap = this.f1577a.c;
        if (bitmap == null) {
            bitmap12 = this.f1577a.r;
            if (bitmap12 == null) {
                return null;
            }
        }
        if (this.b.equals("0") || this.b.equals("1")) {
            this.d = true;
        } else if (this.b.equals("2") || this.b.equals("3")) {
            this.e = true;
        }
        if (!this.d.booleanValue() && !this.e.booleanValue()) {
            bitmap9 = this.f1577a.c;
            if (!bitmap9.isRecycled()) {
                bitmap10 = this.f1577a.c;
                bitmap11 = this.f1577a.c;
                this.c = bitmap10.copy(bitmap11.getConfig(), true);
            }
        } else {
            bitmap2 = this.f1577a.r;
            if (bitmap2 != null) {
                bitmap6 = this.f1577a.r;
                if (!bitmap6.isRecycled()) {
                    bitmap7 = this.f1577a.r;
                    bitmap8 = this.f1577a.r;
                    this.c = bitmap7.copy(bitmap8.getConfig(), true);
                }
            }
            bitmap3 = this.f1577a.c;
            if (!bitmap3.isRecycled()) {
                bitmap4 = this.f1577a.c;
                bitmap5 = this.f1577a.c;
                this.c = bitmap4.copy(bitmap5.getConfig(), true);
            }
        }
        if (this.c.getWidth() > 600 || this.c.getHeight() > 600) {
            this.c = com.baidu.tieba.util.d.a(this.c, 600);
        }
        if (this.d.booleanValue()) {
            this.c = com.baidu.tieba.util.d.d(this.c, Integer.parseInt(this.b));
        } else if (this.e.booleanValue()) {
            this.c = com.baidu.tieba.util.d.e(this.c, Integer.parseInt(this.b));
        } else {
            this.c = FilterFactory.createOneKeyFilter(this.f1577a, this.b).apply(this.f1577a, this.c);
        }
        return this.c;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        Button button;
        Bitmap bitmap;
        if (this.c != null && !this.c.isRecycled()) {
            bitmap = this.f1577a.r;
            if (bitmap != this.c) {
                this.c.recycle();
            }
        }
        this.c = null;
        progressBar = this.f1577a.j;
        progressBar.setVisibility(8);
        button = this.f1577a.e;
        button.setClickable(true);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005b, code lost:
        if (r0.getHeight() > 600) goto L21;
     */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Bitmap bitmap) {
        ProgressBar progressBar;
        Button button;
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
        progressBar = this.f1577a.j;
        progressBar.setVisibility(8);
        button = this.f1577a.e;
        button.setClickable(true);
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f1577a.y = true;
            imageView = this.f1577a.b;
            imageView.setImageBitmap(bitmap);
            bitmap2 = this.f1577a.c;
            if (bitmap2 != null && (this.d.booleanValue() || this.e.booleanValue())) {
                bitmap6 = this.f1577a.c;
                if (bitmap6.getWidth() <= 600) {
                    bitmap10 = this.f1577a.c;
                }
                WriteImageActivity writeImageActivity = this.f1577a;
                bitmap7 = this.f1577a.c;
                writeImageActivity.c = com.baidu.tieba.util.d.a(bitmap7, 600);
                if (this.d.booleanValue()) {
                    WriteImageActivity writeImageActivity2 = this.f1577a;
                    bitmap9 = this.f1577a.c;
                    writeImageActivity2.c = com.baidu.tieba.util.d.d(bitmap9, Integer.parseInt(this.b));
                } else if (this.e.booleanValue()) {
                    WriteImageActivity writeImageActivity3 = this.f1577a;
                    bitmap8 = this.f1577a.c;
                    writeImageActivity3.c = com.baidu.tieba.util.d.e(bitmap8, Integer.parseInt(this.b));
                }
            }
            bitmap3 = this.f1577a.r;
            if (bitmap3 != null) {
                bitmap4 = this.f1577a.r;
                if (!bitmap4.isRecycled()) {
                    bitmap5 = this.f1577a.r;
                    bitmap5.recycle();
                }
            }
            this.f1577a.r = bitmap;
        }
    }
}
