package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.widget.Button;
import android.widget.ProgressBar;
import cn.jingling.lib.filters.FilterFactory;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.view.EditHeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends BdAsyncTask<String, Void, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditHeadActivity f2256a;
    private String b;
    private Bitmap c;
    private Boolean d;
    private Boolean e;

    private u(EditHeadActivity editHeadActivity) {
        this.f2256a = editHeadActivity;
        this.d = false;
        this.e = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ u(EditHeadActivity editHeadActivity, l lVar) {
        this(editHeadActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        Button button;
        progressBar = this.f2256a.q;
        progressBar.setVisibility(0);
        button = this.f2256a.m;
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
        bitmap = this.f2256a.j;
        if (bitmap == null) {
            bitmap9 = this.f2256a.z;
            if (bitmap9 == null) {
                return null;
            }
        }
        if (this.b.equals(SocialConstants.FALSE) || this.b.equals(SocialConstants.TRUE)) {
            this.d = true;
        } else if (this.b.equals("2") || this.b.equals("3")) {
            this.e = true;
        }
        if (this.d.booleanValue() || this.e.booleanValue()) {
            bitmap2 = this.f2256a.z;
            if (bitmap2 != null) {
                bitmap5 = this.f2256a.z;
                bitmap6 = this.f2256a.z;
                this.c = bitmap5.copy(bitmap6.getConfig(), true);
            } else {
                bitmap3 = this.f2256a.j;
                bitmap4 = this.f2256a.j;
                this.c = bitmap3.copy(bitmap4.getConfig(), true);
            }
        } else {
            bitmap7 = this.f2256a.j;
            bitmap8 = this.f2256a.j;
            this.c = bitmap7.copy(bitmap8.getConfig(), true);
        }
        if (this.d.booleanValue()) {
            this.c = com.baidu.tieba.util.e.d(this.c, Integer.parseInt(this.b));
        } else if (this.e.booleanValue()) {
            this.c = com.baidu.tieba.util.e.f(this.c, Integer.parseInt(this.b));
        } else {
            this.c = FilterFactory.createOneKeyFilter(this.f2256a, this.b).apply(this.f2256a, this.c);
        }
        return this.c;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        Button button;
        Bitmap bitmap;
        if (this.c != null && !this.c.isRecycled()) {
            bitmap = this.f2256a.z;
            if (bitmap != this.c) {
                this.c.recycle();
            }
        }
        this.c = null;
        progressBar = this.f2256a.q;
        progressBar.setVisibility(8);
        button = this.f2256a.m;
        button.setClickable(true);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x005c, code lost:
        if (r0.getHeight() > 750) goto L28;
     */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Bitmap bitmap) {
        ProgressBar progressBar;
        Button button;
        Button button2;
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
        progressBar = this.f2256a.q;
        progressBar.setVisibility(8);
        button = this.f2256a.m;
        button.setClickable(true);
        button2 = this.f2256a.m;
        button2.setEnabled(true);
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f2256a.G = true;
            if (this.d.booleanValue() || this.e.booleanValue()) {
                editHeadImageView = this.f2256a.g;
                editHeadImageView.setImageBitmap(bitmap);
                bitmap2 = this.f2256a.j;
                if (bitmap2.getWidth() <= 750) {
                    bitmap6 = this.f2256a.j;
                }
                EditHeadActivity editHeadActivity = this.f2256a;
                bitmap3 = this.f2256a.j;
                editHeadActivity.j = com.baidu.tieba.util.e.a(bitmap3, 750);
                if (this.d.booleanValue()) {
                    EditHeadActivity editHeadActivity2 = this.f2256a;
                    bitmap5 = this.f2256a.j;
                    editHeadActivity2.j = com.baidu.tieba.util.e.d(bitmap5, Integer.parseInt(this.b));
                } else if (this.e.booleanValue()) {
                    EditHeadActivity editHeadActivity3 = this.f2256a;
                    bitmap4 = this.f2256a.j;
                    editHeadActivity3.j = com.baidu.tieba.util.e.f(bitmap4, Integer.parseInt(this.b));
                }
            } else {
                editHeadImageView2 = this.f2256a.g;
                editHeadImageView2.a(bitmap);
            }
            bitmap7 = this.f2256a.z;
            if (bitmap7 != null) {
                bitmap8 = this.f2256a.z;
                if (!bitmap8.isRecycled()) {
                    bitmap9 = this.f2256a.z;
                    bitmap9.recycle();
                }
            }
            this.f2256a.z = bitmap;
        }
    }
}
