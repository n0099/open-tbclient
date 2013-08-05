package com.baidu.tieba.pb;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f1448a;

    private ag(ImagePbActivity imagePbActivity) {
        this.f1448a = imagePbActivity;
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
            if (this.f1448a.H == null || this.f1448a.H.h() == null || this.f1448a.H.h().get(this.f1448a.K) == null) {
                return null;
            }
            String str = String.valueOf(((com.baidu.tieba.data.z) this.f1448a.H.h().get(this.f1448a.K)).b()) + "_big";
            if (str != null && str.length() > 0 && this.f1448a.H != null) {
                if (com.baidu.tieba.util.ai.f(str) != null) {
                    String str2 = String.valueOf(f) + Util.PHOTO_DEFAULT_EXT;
                    int i = 0;
                    while (com.baidu.tieba.util.p.b(str2) && i < 10000) {
                        i++;
                        str2 = String.valueOf(f) + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + Util.PHOTO_DEFAULT_EXT;
                    }
                    com.baidu.adp.widget.a.b c = com.baidu.tbadk.a.e.a().c(str);
                    if (c != null) {
                        str2 = com.baidu.tieba.util.p.a(null, str2, c.f(), 80);
                    }
                    if (str2 != null) {
                        new com.baidu.tieba.util.t(this.f1448a).a(str2);
                        return this.f1448a.getString(R.string.save_image_to_album);
                    }
                    return com.baidu.tieba.util.p.b();
                }
                return this.f1448a.getString(R.string.save_error);
            }
            return this.f1448a.getString(R.string.save_error);
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b("SaveImageAsyncTask", "doInBackground", "error" + e.getMessage());
            return this.f1448a.getString(R.string.save_error);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        super.a((Object) str);
        if (str != null) {
            this.f1448a.a(str);
        }
        this.f1448a.y = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.f1448a.y = null;
        super.cancel(true);
    }
}
