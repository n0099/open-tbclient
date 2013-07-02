package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.os.Build;
import android.widget.ProgressBar;
import cn.jingling.lib.filters.FilterFactory;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.view.EditHeadImageView;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends BdAsyncTask {
    final /* synthetic */ EditHeadActivity a;

    private u(EditHeadActivity editHeadActivity) {
        this.a = editHeadActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ u(EditHeadActivity editHeadActivity, u uVar) {
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
            Bitmap c = com.baidu.tieba.util.m.c(null, "tieba_resized_image");
            try {
                if (c.getWidth() > 600 || c.getHeight() > 600) {
                    Bitmap a = com.baidu.tieba.util.d.a(c, 600);
                    try {
                        c.recycle();
                        c = a;
                    } catch (Exception e) {
                        e = e;
                        bitmap = a;
                        com.baidu.tieba.util.z.b(getClass().getName(), "GetImageTask", e.toString());
                        return bitmap;
                    }
                }
                if (isCancelled() && c != null && !c.isRecycled()) {
                    c.recycle();
                    return null;
                }
                int a2 = com.baidu.tieba.util.ab.a(this.a, 63.5f);
                if (Build.VERSION.SDK_INT >= 7) {
                    z = this.a.z;
                    if (z) {
                        Bitmap a3 = com.baidu.tieba.util.d.a(com.baidu.tieba.util.d.b(c, a2), com.baidu.tieba.util.ab.a(this.a, 5.0f));
                        this.a.E = new HashMap();
                        this.a.F = new HashMap();
                        hashMap = this.a.E;
                        hashMap.put("normal", a3);
                        strArr = EditHeadActivity.d;
                        for (String str : strArr) {
                            String substring = str.substring(0, str.indexOf("|"));
                            if (!substring.equals("normal")) {
                                Bitmap apply = FilterFactory.createOneKeyFilter(this.a, substring).apply(this.a, a3.copy(a3.getConfig(), true));
                                hashMap2 = this.a.E;
                                hashMap2.put(substring, apply);
                            }
                        }
                        return c;
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
        progressBar = this.a.n;
        progressBar.setVisibility(0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.a.o = null;
        progressBar = this.a.n;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Bitmap bitmap) {
        ProgressBar progressBar;
        EditHeadImageView editHeadImageView;
        boolean z;
        String[] strArr;
        super.a((Object) bitmap);
        this.a.o = null;
        this.a.f = bitmap;
        progressBar = this.a.n;
        progressBar.setVisibility(8);
        if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
            editHeadImageView = this.a.e;
            editHeadImageView.setImageBitmap(bitmap);
            if (Build.VERSION.SDK_INT >= 7) {
                z = this.a.z;
                if (z) {
                    EditHeadActivity editHeadActivity = this.a;
                    strArr = EditHeadActivity.d;
                    editHeadActivity.a(strArr);
                }
            }
        }
    }
}
