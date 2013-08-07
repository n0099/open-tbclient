package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.widget.Button;
import android.widget.ProgressBar;
import cn.jingling.lib.filters.FilterFactory;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.view.EditHeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditHeadActivity f1614a;
    private String b;
    private Bitmap c;
    private Boolean d;
    private Boolean e;

    private t(EditHeadActivity editHeadActivity) {
        this.f1614a = editHeadActivity;
        this.d = false;
        this.e = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ t(EditHeadActivity editHeadActivity, t tVar) {
        this(editHeadActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        Button button;
        progressBar = this.f1614a.n;
        progressBar.setVisibility(0);
        button = this.f1614a.j;
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
        bitmap = this.f1614a.f;
        if (bitmap == null) {
            bitmap9 = this.f1614a.v;
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
            bitmap7 = this.f1614a.f;
            bitmap8 = this.f1614a.f;
            this.c = bitmap7.copy(bitmap8.getConfig(), true);
        } else {
            bitmap2 = this.f1614a.v;
            if (bitmap2 == null) {
                bitmap3 = this.f1614a.f;
                bitmap4 = this.f1614a.f;
                this.c = bitmap3.copy(bitmap4.getConfig(), true);
            } else {
                bitmap5 = this.f1614a.v;
                bitmap6 = this.f1614a.v;
                this.c = bitmap5.copy(bitmap6.getConfig(), true);
            }
        }
        if (this.d.booleanValue()) {
            this.c = com.baidu.tieba.util.e.d(this.c, Integer.parseInt(this.b));
        } else if (this.e.booleanValue()) {
            this.c = com.baidu.tieba.util.e.e(this.c, Integer.parseInt(this.b));
        } else {
            this.c = FilterFactory.createOneKeyFilter(this.f1614a, this.b).apply(this.f1614a, this.c);
        }
        return this.c;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        Button button;
        Bitmap bitmap;
        if (this.c != null && !this.c.isRecycled()) {
            bitmap = this.f1614a.v;
            if (bitmap != this.c) {
                this.c.recycle();
            }
        }
        this.c = null;
        progressBar = this.f1614a.n;
        progressBar.setVisibility(8);
        button = this.f1614a.j;
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
        progressBar = this.f1614a.n;
        progressBar.setVisibility(8);
        button = this.f1614a.j;
        button.setClickable(true);
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f1614a.C = true;
            if (this.d.booleanValue() || this.e.booleanValue()) {
                editHeadImageView = this.f1614a.e;
                editHeadImageView.setImageBitmap(bitmap);
                bitmap2 = this.f1614a.f;
                if (bitmap2.getWidth() <= 600) {
                    bitmap6 = this.f1614a.f;
                }
                EditHeadActivity editHeadActivity = this.f1614a;
                bitmap3 = this.f1614a.f;
                editHeadActivity.f = com.baidu.tieba.util.e.a(bitmap3, 600);
                if (this.d.booleanValue()) {
                    EditHeadActivity editHeadActivity2 = this.f1614a;
                    bitmap5 = this.f1614a.f;
                    editHeadActivity2.f = com.baidu.tieba.util.e.d(bitmap5, Integer.parseInt(this.b));
                } else if (this.e.booleanValue()) {
                    EditHeadActivity editHeadActivity3 = this.f1614a;
                    bitmap4 = this.f1614a.f;
                    editHeadActivity3.f = com.baidu.tieba.util.e.e(bitmap4, Integer.parseInt(this.b));
                }
            } else {
                editHeadImageView2 = this.f1614a.e;
                editHeadImageView2.a(bitmap);
            }
            bitmap7 = this.f1614a.v;
            if (bitmap7 != null) {
                bitmap8 = this.f1614a.v;
                if (!bitmap8.isRecycled()) {
                    bitmap9 = this.f1614a.v;
                    bitmap9.recycle();
                }
            }
            this.f1614a.v = bitmap;
        }
    }
}
