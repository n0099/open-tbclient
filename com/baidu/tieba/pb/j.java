package com.baidu.tieba.pb;

import android.widget.Button;
import android.widget.ProgressBar;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends com.baidu.adp.lib.a.a {
    String a;
    byte[] b;
    final /* synthetic */ ImageActivity c;

    public j(ImageActivity imageActivity, String str, byte[] bArr) {
        this.c = imageActivity;
        this.a = null;
        this.b = null;
        this.a = str;
        this.b = bArr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public String a(String... strArr) {
        String str;
        String f;
        try {
            if (this.a != null && this.a.length() > 0 && this.b != null) {
                if (!com.baidu.tieba.d.ag.a(this.b)) {
                    str = ".jpg";
                } else {
                    str = ".gif";
                }
                if (com.baidu.tieba.d.ad.f(this.a) == null) {
                    return this.c.getString(R.string.save_error);
                }
                String str2 = String.valueOf(f) + str;
                for (int i = 0; com.baidu.tieba.d.o.b(str2) && i < 10000; i++) {
                    str2 = String.valueOf(f) + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + str;
                }
                String a = com.baidu.tieba.d.o.a(str2, this.b);
                if (a != null) {
                    new com.baidu.tieba.d.s(this.c).a(a);
                    return this.c.getString(R.string.save_image_to_album);
                }
                return com.baidu.tieba.d.o.b();
            }
            return this.c.getString(R.string.save_error);
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b("SaveImageAsyncTask", "doInBackground", "error" + e.getMessage());
            return this.c.getString(R.string.save_error);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(String str) {
        Button button;
        ProgressBar progressBar;
        super.a((Object) str);
        this.c.a(str);
        this.c.j = null;
        button = this.c.k;
        button.setVisibility(0);
        progressBar = this.c.c;
        progressBar.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void c() {
        super.c();
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
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
