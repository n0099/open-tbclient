package com.baidu.tieba.person;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Build;
import android.widget.ProgressBar;
import cn.jingling.lib.filters.FilterFactory;
import com.baidu.tieba.view.EditHeadImageView;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends AsyncTask {
    final /* synthetic */ EditHeadActivity a;

    private r(EditHeadActivity editHeadActivity) {
        this.a = editHeadActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r(EditHeadActivity editHeadActivity, r rVar) {
        this(editHeadActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Bitmap doInBackground(Object... objArr) {
        boolean z;
        HashMap hashMap;
        String[] strArr;
        HashMap hashMap2;
        Bitmap bitmap = null;
        try {
            Bitmap c = com.baidu.tieba.c.o.c(null, "tieba_resized_image");
            try {
                if (c.getWidth() > 600 || c.getHeight() > 600) {
                    Bitmap a = com.baidu.tieba.c.e.a(c, 600);
                    try {
                        c.recycle();
                        c = a;
                    } catch (Exception e) {
                        e = e;
                        bitmap = a;
                        com.baidu.tieba.c.ae.b(getClass().getName(), "GetImageTask", e.toString());
                        return bitmap;
                    }
                }
                if (isCancelled() && c != null && !c.isRecycled()) {
                    c.recycle();
                    return null;
                }
                int a2 = com.baidu.tieba.c.ag.a((Context) this.a, 63.5f);
                if (Build.VERSION.SDK_INT >= 7) {
                    z = this.a.y;
                    if (z) {
                        Bitmap a3 = com.baidu.tieba.c.e.a(com.baidu.tieba.c.e.b(c, a2), com.baidu.tieba.c.ag.a((Context) this.a, 5.0f));
                        this.a.D = new HashMap();
                        this.a.E = new HashMap();
                        hashMap = this.a.D;
                        hashMap.put("normal", a3);
                        strArr = EditHeadActivity.e;
                        for (String str : strArr) {
                            String substring = str.substring(0, str.indexOf("|"));
                            if (!substring.equals("normal")) {
                                Bitmap apply = FilterFactory.createOneKeyFilter(this.a, substring).apply(this.a, a3.copy(a3.getConfig(), true));
                                hashMap2 = this.a.D;
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

    public void a() {
        ProgressBar progressBar;
        this.a.n = null;
        progressBar = this.a.m;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        EditHeadImageView editHeadImageView;
        boolean z;
        String[] strArr;
        super.onPostExecute(bitmap);
        this.a.n = null;
        this.a.g = bitmap;
        progressBar = this.a.m;
        progressBar.setVisibility(8);
        if (bitmap == null || bitmap.isRecycled() || bitmap == null) {
            return;
        }
        editHeadImageView = this.a.f;
        editHeadImageView.setImageBitmap(bitmap);
        if (Build.VERSION.SDK_INT >= 7) {
            z = this.a.y;
            if (z) {
                EditHeadActivity editHeadActivity = this.a;
                strArr = EditHeadActivity.e;
                editHeadActivity.a(strArr);
            }
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.a.m;
        progressBar.setVisibility(0);
        super.onPreExecute();
    }
}
