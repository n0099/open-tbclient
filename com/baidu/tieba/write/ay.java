package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import cn.jingling.lib.filters.FilterFactory;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends AsyncTask {
    final /* synthetic */ WriteImageActivity a;
    private String b;
    private Bitmap c;
    private Boolean d;
    private Boolean e;

    private ay(WriteImageActivity writeImageActivity) {
        this.a = writeImageActivity;
        this.d = false;
        this.e = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ay(WriteImageActivity writeImageActivity, ay ayVar) {
        this(writeImageActivity);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        Button button;
        progressBar = this.a.j;
        progressBar.setVisibility(0);
        button = this.a.g;
        button.setClickable(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Bitmap doInBackground(String... strArr) {
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
        bitmap = this.a.e;
        if (bitmap == null) {
            bitmap12 = this.a.r;
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
            bitmap9 = this.a.e;
            if (!bitmap9.isRecycled()) {
                bitmap10 = this.a.e;
                bitmap11 = this.a.e;
                this.c = bitmap10.copy(bitmap11.getConfig(), true);
            }
        } else {
            bitmap2 = this.a.r;
            if (bitmap2 != null) {
                bitmap6 = this.a.r;
                if (!bitmap6.isRecycled()) {
                    bitmap7 = this.a.r;
                    bitmap8 = this.a.r;
                    this.c = bitmap7.copy(bitmap8.getConfig(), true);
                }
            }
            bitmap3 = this.a.e;
            if (!bitmap3.isRecycled()) {
                bitmap4 = this.a.e;
                bitmap5 = this.a.e;
                this.c = bitmap4.copy(bitmap5.getConfig(), true);
            }
        }
        if (this.c.getWidth() > 600 || this.c.getHeight() > 600) {
            this.c = com.baidu.tieba.c.e.a(this.c, 600);
        }
        if (this.d.booleanValue()) {
            this.c = com.baidu.tieba.c.e.d(this.c, Integer.parseInt(this.b));
        } else if (this.e.booleanValue()) {
            this.c = com.baidu.tieba.c.e.e(this.c, Integer.parseInt(this.b));
        } else {
            this.c = FilterFactory.createOneKeyFilter(this.a, this.b).apply(this.a, this.c);
        }
        return this.c;
    }

    public void a() {
        ProgressBar progressBar;
        Button button;
        Bitmap bitmap;
        if (this.c != null && !this.c.isRecycled()) {
            bitmap = this.a.r;
            if (bitmap != this.c) {
                this.c.recycle();
            }
        }
        this.c = null;
        progressBar = this.a.j;
        progressBar.setVisibility(8);
        button = this.a.g;
        button.setClickable(true);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005b, code lost:
        if (r0.getHeight() > 600) goto L21;
     */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPostExecute(Bitmap bitmap) {
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
        progressBar = this.a.j;
        progressBar.setVisibility(8);
        button = this.a.g;
        button.setClickable(true);
        if (bitmap != null && !bitmap.isRecycled()) {
            this.a.y = true;
            imageView = this.a.d;
            imageView.setImageBitmap(bitmap);
            bitmap2 = this.a.e;
            if (bitmap2 != null && (this.d.booleanValue() || this.e.booleanValue())) {
                bitmap6 = this.a.e;
                if (bitmap6.getWidth() <= 600) {
                    bitmap10 = this.a.e;
                }
                WriteImageActivity writeImageActivity = this.a;
                bitmap7 = this.a.e;
                writeImageActivity.e = com.baidu.tieba.c.e.a(bitmap7, 600);
                if (this.d.booleanValue()) {
                    WriteImageActivity writeImageActivity2 = this.a;
                    bitmap9 = this.a.e;
                    writeImageActivity2.e = com.baidu.tieba.c.e.d(bitmap9, Integer.parseInt(this.b));
                } else if (this.e.booleanValue()) {
                    WriteImageActivity writeImageActivity3 = this.a;
                    bitmap8 = this.a.e;
                    writeImageActivity3.e = com.baidu.tieba.c.e.e(bitmap8, Integer.parseInt(this.b));
                }
            }
            bitmap3 = this.a.r;
            if (bitmap3 != null) {
                bitmap4 = this.a.r;
                if (!bitmap4.isRecycled()) {
                    bitmap5 = this.a.r;
                    bitmap5.recycle();
                }
            }
            this.a.r = bitmap;
        }
    }
}
