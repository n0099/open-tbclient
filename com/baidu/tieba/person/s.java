package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.widget.Button;
import android.widget.ProgressBar;
import cn.jingling.lib.filters.FilterFactory;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.view.EditHeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends BdAsyncTask<String, Void, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditHeadActivity f1734a;
    private String b;
    private Bitmap c;
    private Boolean d;
    private Boolean e;

    private s(EditHeadActivity editHeadActivity) {
        this.f1734a = editHeadActivity;
        this.d = false;
        this.e = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ s(EditHeadActivity editHeadActivity, s sVar) {
        this(editHeadActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        Button button;
        progressBar = this.f1734a.n;
        progressBar.setVisibility(0);
        button = this.f1734a.j;
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
        this.b = strArr[0];
        bitmap = this.f1734a.f;
        if (bitmap == null) {
            bitmap9 = this.f1734a.v;
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
            bitmap7 = this.f1734a.f;
            bitmap8 = this.f1734a.f;
            this.c = bitmap7.copy(bitmap8.getConfig(), true);
        } else {
            bitmap2 = this.f1734a.v;
            if (bitmap2 == null) {
                bitmap3 = this.f1734a.f;
                bitmap4 = this.f1734a.f;
                this.c = bitmap3.copy(bitmap4.getConfig(), true);
            } else {
                bitmap5 = this.f1734a.v;
                bitmap6 = this.f1734a.v;
                this.c = bitmap5.copy(bitmap6.getConfig(), true);
            }
        }
        if (this.d.booleanValue()) {
            this.c = com.baidu.tieba.util.e.d(this.c, Integer.parseInt(this.b));
        } else if (this.e.booleanValue()) {
            this.c = com.baidu.tieba.util.e.e(this.c, Integer.parseInt(this.b));
        } else {
            this.c = FilterFactory.createOneKeyFilter(this.f1734a, this.b).apply(this.f1734a, this.c);
        }
        return this.c;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        Button button;
        Bitmap bitmap;
        if (this.c != null && !this.c.isRecycled()) {
            bitmap = this.f1734a.v;
            if (bitmap != this.c) {
                this.c.recycle();
            }
        }
        this.c = null;
        progressBar = this.f1734a.n;
        progressBar.setVisibility(8);
        button = this.f1734a.j;
        button.setClickable(true);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0053, code lost:
        if (r0.getHeight() > 600) goto L28;
     */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Bitmap bitmap) {
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
        progressBar = this.f1734a.n;
        progressBar.setVisibility(8);
        button = this.f1734a.j;
        button.setClickable(true);
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f1734a.C = true;
            if (this.d.booleanValue() || this.e.booleanValue()) {
                editHeadImageView = this.f1734a.e;
                editHeadImageView.setImageBitmap(bitmap);
                bitmap2 = this.f1734a.f;
                if (bitmap2.getWidth() <= 600) {
                    bitmap6 = this.f1734a.f;
                }
                EditHeadActivity editHeadActivity = this.f1734a;
                bitmap3 = this.f1734a.f;
                editHeadActivity.f = com.baidu.tieba.util.e.a(bitmap3, 600);
                if (this.d.booleanValue()) {
                    EditHeadActivity editHeadActivity2 = this.f1734a;
                    bitmap5 = this.f1734a.f;
                    editHeadActivity2.f = com.baidu.tieba.util.e.d(bitmap5, Integer.parseInt(this.b));
                } else if (this.e.booleanValue()) {
                    EditHeadActivity editHeadActivity3 = this.f1734a;
                    bitmap4 = this.f1734a.f;
                    editHeadActivity3.f = com.baidu.tieba.util.e.e(bitmap4, Integer.parseInt(this.b));
                }
            } else {
                editHeadImageView2 = this.f1734a.e;
                editHeadImageView2.a(bitmap);
            }
            bitmap7 = this.f1734a.v;
            if (bitmap7 != null) {
                bitmap8 = this.f1734a.v;
                if (!bitmap8.isRecycled()) {
                    bitmap9 = this.f1734a.v;
                    bitmap9.recycle();
                }
            }
            this.f1734a.v = bitmap;
        }
    }
}
