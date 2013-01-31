package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.ProgressBar;
import cn.jingling.lib.filters.FilterFactory;
import com.baidu.tieba.view.EditHeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends AsyncTask {
    final /* synthetic */ EditHeadActivity a;
    private String b;
    private Bitmap c;
    private Boolean d;
    private Boolean e;

    private s(EditHeadActivity editHeadActivity) {
        this.a = editHeadActivity;
        this.d = false;
        this.e = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ s(EditHeadActivity editHeadActivity, s sVar) {
        this(editHeadActivity);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        Button button;
        progressBar = this.a.n;
        progressBar.setVisibility(0);
        button = this.a.j;
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
        this.b = strArr[0];
        bitmap = this.a.h;
        if (bitmap == null) {
            bitmap9 = this.a.v;
            if (bitmap9 == null) {
                return null;
            }
        }
        if (this.b.equals("0") || this.b.equals("1")) {
            this.d = true;
        } else if (this.b.equals("2") || this.b.equals("3")) {
            this.e = true;
        }
        if (!this.d.booleanValue() && !this.e.booleanValue()) {
            bitmap7 = this.a.h;
            bitmap8 = this.a.h;
            this.c = bitmap7.copy(bitmap8.getConfig(), true);
        } else {
            bitmap2 = this.a.v;
            if (bitmap2 == null) {
                bitmap3 = this.a.h;
                bitmap4 = this.a.h;
                this.c = bitmap3.copy(bitmap4.getConfig(), true);
            } else {
                bitmap5 = this.a.v;
                bitmap6 = this.a.v;
                this.c = bitmap5.copy(bitmap6.getConfig(), true);
            }
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
            bitmap = this.a.v;
            if (bitmap != this.c) {
                this.c.recycle();
            }
        }
        this.c = null;
        progressBar = this.a.n;
        progressBar.setVisibility(8);
        button = this.a.j;
        button.setClickable(true);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0053, code lost:
        if (r0.getHeight() > 600) goto L28;
     */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        Button button;
        EditHeadImageView editHeadImageView;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap bitmap4;
        Bitmap bitmap5;
        Bitmap bitmap6;
        Bitmap bitmap7;
        Bitmap bitmap8;
        Bitmap bitmap9;
        EditHeadImageView editHeadImageView2;
        progressBar = this.a.n;
        progressBar.setVisibility(8);
        button = this.a.j;
        button.setClickable(true);
        if (bitmap != null && !bitmap.isRecycled()) {
            this.a.C = true;
            if (this.d.booleanValue() || this.e.booleanValue()) {
                editHeadImageView = this.a.g;
                editHeadImageView.setImageBitmap(bitmap);
                bitmap2 = this.a.h;
                if (bitmap2.getWidth() <= 600) {
                    bitmap6 = this.a.h;
                }
                EditHeadActivity editHeadActivity = this.a;
                bitmap3 = this.a.h;
                editHeadActivity.h = com.baidu.tieba.c.e.a(bitmap3, 600);
                if (this.d.booleanValue()) {
                    EditHeadActivity editHeadActivity2 = this.a;
                    bitmap5 = this.a.h;
                    editHeadActivity2.h = com.baidu.tieba.c.e.d(bitmap5, Integer.parseInt(this.b));
                } else if (this.e.booleanValue()) {
                    EditHeadActivity editHeadActivity3 = this.a;
                    bitmap4 = this.a.h;
                    editHeadActivity3.h = com.baidu.tieba.c.e.e(bitmap4, Integer.parseInt(this.b));
                }
            } else {
                editHeadImageView2 = this.a.g;
                editHeadImageView2.a(bitmap);
            }
            bitmap7 = this.a.v;
            if (bitmap7 != null) {
                bitmap8 = this.a.v;
                if (!bitmap8.isRecycled()) {
                    bitmap9 = this.a.v;
                    bitmap9.recycle();
                }
            }
            this.a.v = bitmap;
        }
    }
}
