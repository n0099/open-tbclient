package com.baidu.tieba.pb;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ ImagePbActivity a;

    private af(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ af(ImagePbActivity imagePbActivity, k kVar) {
        this(imagePbActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        try {
            if (this.a.G == null || this.a.G.h() == null || this.a.G.h().get(this.a.J) == null) {
                return null;
            }
            String str = this.a.G.h().get(this.a.J).b() + "_big";
            if (str != null && str.length() > 0 && this.a.G != null) {
                String f = com.baidu.tieba.util.bu.f(str);
                if (f != null) {
                    String str2 = f + ".jpg";
                    int i = 0;
                    while (com.baidu.tieba.util.ad.b(str2) && i < 10000) {
                        i++;
                        str2 = f + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + ".jpg";
                    }
                    com.baidu.adp.widget.ImageView.d c = com.baidu.tbadk.imageManager.d.a().c(str);
                    if (c != null) {
                        str2 = com.baidu.tieba.util.ad.a((String) null, str2, c.h(), 80);
                    }
                    if (str2 != null) {
                        new com.baidu.tieba.util.aw(this.a).a(str2);
                        return this.a.getString(R.string.save_image_to_album);
                    }
                    return com.baidu.tieba.util.ad.b();
                }
                return this.a.getString(R.string.save_error);
            }
            return this.a.getString(R.string.save_error);
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b("SaveImageAsyncTask", "doInBackground", "error" + e.getMessage());
            return this.a.getString(R.string.save_error);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        super.a((af) str);
        if (str != null) {
            this.a.showToast(str);
        }
        this.a.x = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.a.x = null;
        super.cancel(true);
    }
}
