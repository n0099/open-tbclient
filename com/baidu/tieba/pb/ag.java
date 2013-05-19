package com.baidu.tieba.pb;

import android.graphics.Bitmap;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends com.baidu.adp.lib.a.a {
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
    @Override // com.baidu.adp.lib.a.a
    public String a(String... strArr) {
        String f;
        try {
            if (this.a.H == null || this.a.H.h() == null || this.a.H.h().get(this.a.K) == null) {
                return null;
            }
            String str = String.valueOf(((com.baidu.tieba.a.w) this.a.H.h().get(this.a.K)).b()) + "_big";
            if (str != null && str.length() > 0 && this.a.H != null) {
                if (com.baidu.tieba.d.ad.f(str) != null) {
                    String str2 = String.valueOf(f) + ".jpg";
                    int i = 0;
                    while (com.baidu.tieba.d.o.b(str2) && i < 10000) {
                        i++;
                        str2 = String.valueOf(f) + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + ".jpg";
                    }
                    Bitmap c = com.baidu.tbadk.a.d.a().c(str);
                    if (c != null) {
                        str2 = com.baidu.tieba.d.o.a(null, str2, c, 80);
                    }
                    if (str2 != null) {
                        new com.baidu.tieba.d.s(this.a).a(str2);
                        return this.a.getString(R.string.save_image_to_album);
                    }
                    return com.baidu.tieba.d.o.b();
                }
                return this.a.getString(R.string.save_error);
            }
            return this.a.getString(R.string.save_error);
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b("SaveImageAsyncTask", "doInBackground", "error" + e.getMessage());
            return this.a.getString(R.string.save_error);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(String str) {
        super.a((Object) str);
        if (str != null) {
            this.a.a(str);
        }
        this.a.y = null;
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        this.a.y = null;
        super.cancel(true);
    }
}
