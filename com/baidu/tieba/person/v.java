package com.baidu.tieba.person;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.widget.ProgressBar;
import android.widget.TextView;
import cn.jingling.lib.filters.FilterFactory;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.view.EditHeadImageView;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ EditHeadActivity a;

    private v(EditHeadActivity editHeadActivity) {
        this.a = editHeadActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ v(EditHeadActivity editHeadActivity, l lVar) {
        this(editHeadActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Bitmap a(Object... objArr) {
        boolean z;
        HashMap hashMap;
        String[] strArr;
        HashMap hashMap2;
        Bitmap bitmap = null;
        try {
            Bitmap c = com.baidu.tieba.util.ad.c(null, "tieba_resized_image");
            try {
                if (c.getWidth() > 750 || c.getHeight() > 750) {
                    Bitmap a = com.baidu.tieba.util.n.a(c, 750);
                    try {
                        c.recycle();
                        c = a;
                    } catch (Exception e) {
                        e = e;
                        bitmap = a;
                        com.baidu.adp.lib.g.e.b(getClass().getName(), "GetImageTask", e.toString());
                        return bitmap;
                    }
                }
                if (isCancelled() && c != null && !c.isRecycled()) {
                    c.recycle();
                    return null;
                }
                int a2 = com.baidu.adp.lib.g.g.a((Context) this.a, 63.5f);
                if (Build.VERSION.SDK_INT >= 7) {
                    z = this.a.A;
                    if (z) {
                        Bitmap a3 = com.baidu.tieba.util.n.a(com.baidu.tieba.util.n.b(c, a2), com.baidu.adp.lib.g.g.a((Context) this.a, 5.0f));
                        this.a.F = new HashMap();
                        this.a.G = new HashMap();
                        hashMap = this.a.F;
                        hashMap.put("normal", a3);
                        strArr = EditHeadActivity.f;
                        for (String str : strArr) {
                            String substring = str.substring(0, str.indexOf("|"));
                            if (!substring.equals("normal")) {
                                Bitmap apply = FilterFactory.createOneKeyFilter(this.a, substring).apply(this.a, a3.copy(a3.getConfig() == null ? com.baidu.tieba.data.h.m : a3.getConfig(), true));
                                hashMap2 = this.a.F;
                                hashMap2.put(substring, apply);
                            }
                        }
                    }
                }
                return c;
            } catch (Exception e2) {
                bitmap = c;
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        TextView textView;
        progressBar = this.a.n;
        progressBar.setVisibility(0);
        textView = this.a.j;
        textView.setEnabled(false);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        TextView textView;
        this.a.o = null;
        progressBar = this.a.n;
        progressBar.setVisibility(8);
        textView = this.a.j;
        textView.setEnabled(true);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Bitmap bitmap) {
        ProgressBar progressBar;
        TextView textView;
        EditHeadImageView editHeadImageView;
        boolean z;
        String[] strArr;
        super.a((v) bitmap);
        this.a.o = null;
        this.a.h = bitmap;
        progressBar = this.a.n;
        progressBar.setVisibility(8);
        textView = this.a.j;
        textView.setEnabled(true);
        if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
            editHeadImageView = this.a.g;
            editHeadImageView.setImageBitmap(bitmap);
            if (Build.VERSION.SDK_INT >= 7) {
                z = this.a.A;
                if (z) {
                    EditHeadActivity editHeadActivity = this.a;
                    strArr = EditHeadActivity.f;
                    editHeadActivity.a(strArr);
                }
            }
        }
    }
}
