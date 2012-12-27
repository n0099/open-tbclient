package com.baidu.tieba.pb;

import android.os.AsyncTask;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends AsyncTask {
    final /* synthetic */ ImagePbActivity a;

    private af(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ af(ImagePbActivity imagePbActivity, af afVar) {
        this(imagePbActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        String g;
        try {
            if (this.a.F == null || this.a.F.h() == null || this.a.F.h().get(this.a.I) == null) {
                return null;
            }
            String str = String.valueOf(((com.baidu.tieba.a.t) this.a.F.h().get(this.a.I)).b()) + "_big";
            if (str == null || str.length() <= 0 || this.a.F == null) {
                return this.a.getString(R.string.save_error);
            }
            if (com.baidu.tieba.c.ad.g(str) == null) {
                return this.a.getString(R.string.save_error);
            }
            String str2 = String.valueOf(g) + ".jpg";
            int i = 0;
            while (com.baidu.tieba.c.o.b(str2) && i < 10000) {
                i++;
                str2 = String.valueOf(g) + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + ".jpg";
            }
            if (TiebaApplication.a().ah().c(str) != null) {
                str2 = com.baidu.tieba.c.o.a(null, str2, TiebaApplication.a().ah().c(str), 80);
            }
            if (str2 != null) {
                new com.baidu.tieba.c.s(this.a).a(str2);
                return this.a.getString(R.string.save_image_to_album);
            }
            return com.baidu.tieba.c.o.b();
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b("SaveImageAsyncTask", "doInBackground", "error" + e.getMessage());
            return this.a.getString(R.string.save_error);
        }
    }

    public void a() {
        this.a.w = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        super.onPostExecute(str);
        if (str != null) {
            this.a.b(str);
        }
        this.a.w = null;
    }
}
