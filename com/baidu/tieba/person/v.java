package com.baidu.tieba.person;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.widget.ProgressBar;
import android.widget.TextView;
import cn.jingling.lib.filters.FilterFactory;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.EditHeadImageView;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends BdAsyncTask<Object, Integer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditHeadActivity f2277a;

    private v(EditHeadActivity editHeadActivity) {
        this.f2277a = editHeadActivity;
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
            Bitmap d = com.baidu.tieba.util.af.d(null, "tieba_resized_image");
            try {
                if (d.getWidth() > 750 || d.getHeight() > 750) {
                    Bitmap a2 = com.baidu.tieba.util.m.a(d, 750);
                    try {
                        d.recycle();
                        d = a2;
                    } catch (Exception e) {
                        e = e;
                        bitmap = a2;
                        com.baidu.tieba.util.bg.b(getClass().getName(), "GetImageTask", e.toString());
                        return bitmap;
                    }
                }
                if (isCancelled() && d != null && !d.isRecycled()) {
                    d.recycle();
                    return null;
                }
                int a3 = UtilHelper.a((Context) this.f2277a, 63.5f);
                if (Build.VERSION.SDK_INT >= 7) {
                    z = this.f2277a.B;
                    if (z) {
                        Bitmap a4 = com.baidu.tieba.util.m.a(com.baidu.tieba.util.m.b(d, a3), UtilHelper.a((Context) this.f2277a, 5.0f));
                        this.f2277a.G = new HashMap();
                        this.f2277a.H = new HashMap();
                        hashMap = this.f2277a.G;
                        hashMap.put("normal", a4);
                        strArr = EditHeadActivity.f;
                        for (String str : strArr) {
                            String substring = str.substring(0, str.indexOf("|"));
                            if (!substring.equals("normal")) {
                                Bitmap apply = FilterFactory.createOneKeyFilter(this.f2277a, substring).apply(this.f2277a, a4.copy(a4.getConfig() == null ? com.baidu.tieba.data.h.n : a4.getConfig(), true));
                                hashMap2 = this.f2277a.G;
                                hashMap2.put(substring, apply);
                            }
                        }
                    }
                }
                return d;
            } catch (Exception e2) {
                bitmap = d;
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
        progressBar = this.f2277a.o;
        progressBar.setVisibility(0);
        textView = this.f2277a.k;
        textView.setEnabled(false);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        TextView textView;
        this.f2277a.p = null;
        progressBar = this.f2277a.o;
        progressBar.setVisibility(8);
        textView = this.f2277a.k;
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
        this.f2277a.p = null;
        this.f2277a.h = bitmap;
        progressBar = this.f2277a.o;
        progressBar.setVisibility(8);
        textView = this.f2277a.k;
        textView.setEnabled(true);
        if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
            editHeadImageView = this.f2277a.g;
            editHeadImageView.setImageBitmap(bitmap);
            if (Build.VERSION.SDK_INT >= 7) {
                z = this.f2277a.B;
                if (z) {
                    EditHeadActivity editHeadActivity = this.f2277a;
                    strArr = EditHeadActivity.f;
                    editHeadActivity.a(strArr);
                }
            }
        }
    }
}
