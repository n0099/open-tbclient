package com.baidu.tieba.pb;

import android.widget.Button;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    String f1534a;
    byte[] b;
    final /* synthetic */ ImageActivity c;

    public j(ImageActivity imageActivity, String str, byte[] bArr) {
        this.c = imageActivity;
        this.f1534a = null;
        this.b = null;
        this.f1534a = str;
        this.b = bArr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        String str;
        String f;
        try {
            if (this.f1534a != null && this.f1534a.length() > 0 && this.b != null) {
                if (!com.baidu.tieba.util.am.a(this.b)) {
                    str = Util.PHOTO_DEFAULT_EXT;
                } else {
                    str = ".gif";
                }
                if (com.baidu.tieba.util.ai.f(this.f1534a) == null) {
                    return this.c.getString(R.string.save_error);
                }
                String str2 = String.valueOf(f) + str;
                for (int i = 0; com.baidu.tieba.util.p.b(str2) && i < 10000; i++) {
                    str2 = String.valueOf(f) + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + str;
                }
                String a2 = com.baidu.tieba.util.p.a(str2, this.b);
                if (a2 != null) {
                    new com.baidu.tieba.util.t(this.c).a(a2);
                    return this.c.getString(R.string.save_image_to_album);
                }
                return com.baidu.tieba.util.p.b();
            }
            return this.c.getString(R.string.save_error);
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b("SaveImageAsyncTask", "doInBackground", "error" + e.getMessage());
            return this.c.getString(R.string.save_error);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        Button button;
        ProgressBar progressBar;
        super.a((Object) str);
        this.c.a(str);
        this.c.j = null;
        button = this.c.k;
        button.setVisibility(0);
        progressBar = this.c.f1436a;
        progressBar.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void c() {
        super.c();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        Button button;
        ProgressBar progressBar;
        this.c.j = null;
        button = this.c.k;
        button.setVisibility(0);
        progressBar = this.c.f1436a;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
