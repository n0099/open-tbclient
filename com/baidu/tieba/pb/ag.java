package com.baidu.tieba.pb;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends BdAsyncTask {
    final /* synthetic */ ImagePbActivity a;

    private ag(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ag(ImagePbActivity imagePbActivity, ag agVar) {
        this(imagePbActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        String f;
        try {
            if (this.a.H == null || this.a.H.h() == null || this.a.H.h().get(this.a.K) == null) {
                return null;
            }
            String str = String.valueOf(((com.baidu.tieba.data.v) this.a.H.h().get(this.a.K)).b()) + "_big";
            if (str != null && str.length() > 0 && this.a.H != null) {
                if (com.baidu.tieba.util.y.f(str) != null) {
                    String str2 = String.valueOf(f) + ".jpg";
                    int i = 0;
                    while (com.baidu.tieba.util.m.b(str2) && i < 10000) {
                        i++;
                        str2 = String.valueOf(f) + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + ".jpg";
                    }
                    com.baidu.adp.widget.a.b c = com.baidu.tbadk.a.e.a().c(str);
                    if (c != null) {
                        str2 = com.baidu.tieba.util.m.a(null, str2, c.f(), 80);
                    }
                    if (str2 != null) {
                        new com.baidu.tieba.util.q(this.a).a(str2);
                        return this.a.getString(R.string.save_image_to_album);
                    }
                    return com.baidu.tieba.util.m.b();
                }
                return this.a.getString(R.string.save_error);
            }
            return this.a.getString(R.string.save_error);
        } catch (Exception e) {
            com.baidu.tieba.util.z.b("SaveImageAsyncTask", "doInBackground", "error" + e.getMessage());
            return this.a.getString(R.string.save_error);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        super.a((Object) str);
        if (str != null) {
            this.a.a(str);
        }
        this.a.y = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.a.y = null;
        super.cancel(true);
    }
}
