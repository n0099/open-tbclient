package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.widget.ProgressBar;
import android.widget.TextView;
import cn.jingling.lib.filters.FilterFactory;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.view.EditHeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends BdAsyncTask<String, Void, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditHeadActivity f2394a;
    private String b;
    private Bitmap c;
    private Boolean d;
    private Boolean e;

    private u(EditHeadActivity editHeadActivity) {
        this.f2394a = editHeadActivity;
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
        TextView textView;
        progressBar = this.f2394a.o;
        progressBar.setVisibility(0);
        textView = this.f2394a.k;
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
        this.b = strArr[0];
        bitmap = this.f2394a.h;
        if (bitmap == null) {
            bitmap9 = this.f2394a.x;
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
            bitmap2 = this.f2394a.x;
            if (bitmap2 != null) {
                bitmap5 = this.f2394a.x;
                bitmap6 = this.f2394a.x;
                this.c = bitmap5.copy(bitmap6.getConfig(), true);
            } else {
                bitmap3 = this.f2394a.h;
                bitmap4 = this.f2394a.h;
                this.c = bitmap3.copy(bitmap4.getConfig(), true);
            }
        } else {
            bitmap7 = this.f2394a.h;
            bitmap8 = this.f2394a.h;
            this.c = bitmap7.copy(bitmap8.getConfig(), true);
        }
        if (this.d.booleanValue()) {
            this.c = com.baidu.tieba.util.m.d(this.c, Integer.parseInt(this.b));
        } else if (this.e.booleanValue()) {
            this.c = com.baidu.tieba.util.m.f(this.c, Integer.parseInt(this.b));
        } else {
            this.c = FilterFactory.createOneKeyFilter(this.f2394a, this.b).apply(this.f2394a, this.c);
        }
        return this.c;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        TextView textView;
        Bitmap bitmap;
        if (this.c != null && !this.c.isRecycled()) {
            bitmap = this.f2394a.x;
            if (bitmap != this.c) {
                this.c.recycle();
            }
        }
        this.c = null;
        progressBar = this.f2394a.o;
        progressBar.setVisibility(8);
        textView = this.f2394a.k;
        textView.setClickable(true);
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
        TextView textView;
        TextView textView2;
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
        progressBar = this.f2394a.o;
        progressBar.setVisibility(8);
        textView = this.f2394a.k;
        textView.setClickable(true);
        textView2 = this.f2394a.k;
        textView2.setEnabled(true);
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f2394a.E = true;
            if (this.d.booleanValue() || this.e.booleanValue()) {
                editHeadImageView = this.f2394a.g;
                editHeadImageView.setImageBitmap(bitmap);
                bitmap2 = this.f2394a.h;
                if (bitmap2.getWidth() <= 750) {
                    bitmap6 = this.f2394a.h;
                }
                EditHeadActivity editHeadActivity = this.f2394a;
                bitmap3 = this.f2394a.h;
                editHeadActivity.h = com.baidu.tieba.util.m.a(bitmap3, 750);
                if (this.d.booleanValue()) {
                    EditHeadActivity editHeadActivity2 = this.f2394a;
                    bitmap5 = this.f2394a.h;
                    editHeadActivity2.h = com.baidu.tieba.util.m.d(bitmap5, Integer.parseInt(this.b));
                } else if (this.e.booleanValue()) {
                    EditHeadActivity editHeadActivity3 = this.f2394a;
                    bitmap4 = this.f2394a.h;
                    editHeadActivity3.h = com.baidu.tieba.util.m.f(bitmap4, Integer.parseInt(this.b));
                }
            } else {
                editHeadImageView2 = this.f2394a.g;
                editHeadImageView2.a(bitmap);
            }
            bitmap7 = this.f2394a.x;
            if (bitmap7 != null) {
                bitmap8 = this.f2394a.x;
                if (!bitmap8.isRecycled()) {
                    bitmap9 = this.f2394a.x;
                    bitmap9.recycle();
                }
            }
            this.f2394a.x = bitmap;
        }
    }
}
