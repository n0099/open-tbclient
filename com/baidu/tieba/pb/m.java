package com.baidu.tieba.pb;

import android.os.AsyncTask;
import android.widget.Button;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends AsyncTask {
    String a;
    byte[] b;
    final /* synthetic */ ImageActivity c;

    public m(ImageActivity imageActivity, String str, byte[] bArr) {
        this.c = imageActivity;
        this.a = null;
        this.b = null;
        this.a = str;
        this.b = bArr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        String str;
        String h;
        try {
            if (this.a != null && this.a.length() > 0 && this.b != null) {
                if (!com.baidu.tieba.c.ai.a(this.b)) {
                    str = ".jpg";
                } else {
                    str = ".gif";
                }
                if (com.baidu.tieba.c.af.h(this.a) == null) {
                    return this.c.getString(R.string.save_error);
                }
                String str2 = String.valueOf(h) + str;
                for (int i = 0; com.baidu.tieba.c.o.b(str2) && i < 10000; i++) {
                    str2 = String.valueOf(h) + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + str;
                }
                String a = com.baidu.tieba.c.o.a(str2, this.b);
                if (a != null) {
                    new com.baidu.tieba.c.s(this.c).a(a);
                    return this.c.getString(R.string.save_image_to_album);
                }
                return com.baidu.tieba.c.o.b();
            }
            return this.c.getString(R.string.save_error);
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b("SaveImageAsyncTask", "doInBackground", "error" + e.getMessage());
            return this.c.getString(R.string.save_error);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        Button button;
        ProgressBar progressBar;
        super.onPostExecute(str);
        this.c.b(str);
        this.c.j = null;
        button = this.c.k;
        button.setVisibility(0);
        progressBar = this.c.c;
        progressBar.setVisibility(8);
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
    }

    public void a() {
        Button button;
        ProgressBar progressBar;
        this.c.j = null;
        button = this.c.k;
        button.setVisibility(0);
        progressBar = this.c.c;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
