package com.baidu.tieba.person;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd extends BdAsyncTask<String, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    String f2330a;
    byte[] b;
    final /* synthetic */ PersonImageActivity c;

    public bd(PersonImageActivity personImageActivity, String str, byte[] bArr) {
        this.c = personImageActivity;
        this.f2330a = null;
        this.b = null;
        this.f2330a = str;
        this.b = bArr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        String str;
        try {
            if (this.f2330a != null && this.f2330a.length() > 0 && this.b != null) {
                if (!com.baidu.adp.lib.h.g.a(this.b)) {
                    str = Util.PHOTO_DEFAULT_EXT;
                } else {
                    str = ".gif";
                }
                String f = com.baidu.tieba.util.bb.f(this.f2330a);
                if (f == null) {
                    return this.c.getString(R.string.save_error);
                }
                String str2 = f + str;
                for (int i = 0; com.baidu.tieba.util.x.b(str2) && i < 10000; i++) {
                    str2 = f + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + str;
                }
                String a2 = com.baidu.tieba.util.x.a(str2, this.b);
                if (a2 != null) {
                    new com.baidu.tieba.util.al(this.c).a(a2);
                    return this.c.getString(R.string.save_image_to_album);
                }
                return com.baidu.tieba.util.x.b();
            }
            return this.c.getString(R.string.save_error);
        } catch (Exception e) {
            com.baidu.tieba.util.bd.b("SaveImageAsyncTask", "doInBackground", "error" + e.getMessage());
            return this.c.getString(R.string.save_error);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        ProgressBar progressBar;
        super.a((bd) str);
        this.c.showToast(str);
        this.c.b = null;
        progressBar = this.c.f2296a;
        progressBar.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void c() {
        super.c();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.c.b = null;
        progressBar = this.c.f2296a;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
