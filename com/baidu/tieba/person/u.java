package com.baidu.tieba.person;

import android.content.Context;
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

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditHeadActivity f1617a;

    private u(EditHeadActivity editHeadActivity) {
        this.f1617a = editHeadActivity;
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
            Bitmap c = com.baidu.tieba.util.p.c(null, "tieba_resized_image");
            try {
                if (c.getWidth() > 600 || c.getHeight() > 600) {
                    Bitmap a2 = com.baidu.tieba.util.e.a(c, 600);
                    try {
                        c.recycle();
                        c = a2;
                    } catch (Exception e) {
                        e = e;
                        bitmap = a2;
                        com.baidu.tieba.util.aj.b(getClass().getName(), "GetImageTask", e.toString());
                        return bitmap;
                    }
                }
                if (isCancelled() && c != null && !c.isRecycled()) {
                    c.recycle();
                    return null;
                }
                int a3 = com.baidu.tieba.util.am.a((Context) this.f1617a, 63.5f);
                if (Build.VERSION.SDK_INT >= 7) {
                    z = this.f1617a.z;
                    if (z) {
                        Bitmap a4 = com.baidu.tieba.util.e.a(com.baidu.tieba.util.e.b(c, a3), com.baidu.tieba.util.am.a((Context) this.f1617a, 5.0f));
                        this.f1617a.E = new HashMap();
                        this.f1617a.F = new HashMap();
                        hashMap = this.f1617a.E;
                        hashMap.put("normal", a4);
                        strArr = EditHeadActivity.d;
                        for (String str : strArr) {
                            String substring = str.substring(0, str.indexOf("|"));
                            if (!substring.equals("normal")) {
                                Bitmap apply = FilterFactory.createOneKeyFilter(this.f1617a, substring).apply(this.f1617a, a4.copy(a4.getConfig(), true));
                                hashMap2 = this.f1617a.E;
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
        progressBar = this.f1617a.n;
        progressBar.setVisibility(0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.f1617a.o = null;
        progressBar = this.f1617a.n;
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
        this.f1617a.o = null;
        this.f1617a.f = bitmap;
        progressBar = this.f1617a.n;
        progressBar.setVisibility(8);
        if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
            editHeadImageView = this.f1617a.e;
            editHeadImageView.setImageBitmap(bitmap);
            if (Build.VERSION.SDK_INT >= 7) {
                z = this.f1617a.z;
                if (z) {
                    EditHeadActivity editHeadActivity = this.f1617a;
                    strArr = EditHeadActivity.d;
                    editHeadActivity.a(strArr);
                }
            }
        }
    }
}
