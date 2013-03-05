package com.baidu.tieba.pb;

import android.os.AsyncTask;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends AsyncTask {
    final /* synthetic */ ImagePbActivity a;

    private aj(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aj(ImagePbActivity imagePbActivity, aj ajVar) {
        this(imagePbActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        String h;
        try {
            if (this.a.H == null || this.a.H.h() == null || this.a.H.h().get(this.a.K) == null) {
                return null;
            }
            String str = String.valueOf(((com.baidu.tieba.a.u) this.a.H.h().get(this.a.K)).b()) + "_big";
            if (str != null && str.length() > 0 && this.a.H != null) {
                if (com.baidu.tieba.c.af.h(str) != null) {
                    String str2 = String.valueOf(h) + ".jpg";
                    int i = 0;
                    while (com.baidu.tieba.c.o.b(str2) && i < 10000) {
                        i++;
                        str2 = String.valueOf(h) + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + ".jpg";
                    }
                    if (TiebaApplication.b().al().c(str) != null) {
                        str2 = com.baidu.tieba.c.o.a(null, str2, TiebaApplication.b().al().c(str), 80);
                    }
                    if (str2 != null) {
                        new com.baidu.tieba.c.s(this.a).a(str2);
                        return this.a.getString(R.string.save_image_to_album);
                    }
                    return com.baidu.tieba.c.o.b();
                }
                return this.a.getString(R.string.save_error);
            }
            return this.a.getString(R.string.save_error);
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b("SaveImageAsyncTask", "doInBackground", "error" + e.getMessage());
            return this.a.getString(R.string.save_error);
        }
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
        this.a.y = null;
    }

    public void a() {
        this.a.y = null;
        super.cancel(true);
    }
}
