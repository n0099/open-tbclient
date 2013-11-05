package com.baidu.tieba.person;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.widget.Button;
import android.widget.ProgressBar;
import cn.jingling.lib.filters.FilterFactory;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.EditHeadImageView;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends BdAsyncTask<Object, Integer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditHeadActivity f2257a;

    private v(EditHeadActivity editHeadActivity) {
        this.f2257a = editHeadActivity;
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
            Bitmap c = com.baidu.tieba.util.w.c(null, "tieba_resized_image");
            try {
                if (c.getWidth() > 750 || c.getHeight() > 750) {
                    Bitmap a2 = com.baidu.tieba.util.e.a(c, 750);
                    try {
                        c.recycle();
                        c = a2;
                    } catch (Exception e) {
                        e = e;
                        bitmap = a2;
                        com.baidu.tieba.util.be.b(getClass().getName(), "GetImageTask", e.toString());
                        return bitmap;
                    }
                }
                if (isCancelled() && c != null && !c.isRecycled()) {
                    c.recycle();
                    return null;
                }
                int a3 = UtilHelper.a((Context) this.f2257a, 63.5f);
                if (Build.VERSION.SDK_INT >= 7) {
                    z = this.f2257a.D;
                    if (z) {
                        Bitmap a4 = com.baidu.tieba.util.e.a(com.baidu.tieba.util.e.b(c, a3), UtilHelper.a((Context) this.f2257a, 5.0f));
                        this.f2257a.I = new HashMap();
                        this.f2257a.J = new HashMap();
                        hashMap = this.f2257a.I;
                        hashMap.put("normal", a4);
                        strArr = EditHeadActivity.f;
                        for (String str : strArr) {
                            String substring = str.substring(0, str.indexOf("|"));
                            if (!substring.equals("normal")) {
                                Bitmap apply = FilterFactory.createOneKeyFilter(this.f2257a, substring).apply(this.f2257a, a4.copy(a4.getConfig() == null ? com.baidu.tieba.data.h.m : a4.getConfig(), true));
                                hashMap2 = this.f2257a.I;
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
        Button button;
        progressBar = this.f2257a.q;
        progressBar.setVisibility(0);
        button = this.f2257a.m;
        button.setEnabled(false);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        Button button;
        this.f2257a.r = null;
        progressBar = this.f2257a.q;
        progressBar.setVisibility(8);
        button = this.f2257a.m;
        button.setEnabled(true);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Bitmap bitmap) {
        ProgressBar progressBar;
        Button button;
        EditHeadImageView editHeadImageView;
        boolean z;
        String[] strArr;
        super.a((v) bitmap);
        this.f2257a.r = null;
        this.f2257a.j = bitmap;
        progressBar = this.f2257a.q;
        progressBar.setVisibility(8);
        button = this.f2257a.m;
        button.setEnabled(true);
        if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
            editHeadImageView = this.f2257a.g;
            editHeadImageView.setImageBitmap(bitmap);
            if (Build.VERSION.SDK_INT >= 7) {
                z = this.f2257a.D;
                if (z) {
                    EditHeadActivity editHeadActivity = this.f2257a;
                    strArr = EditHeadActivity.f;
                    editHeadActivity.a(strArr);
                }
            }
        }
    }
}
