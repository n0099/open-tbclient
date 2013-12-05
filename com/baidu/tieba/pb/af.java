package com.baidu.tieba.pb;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends BdAsyncTask<String, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f2153a;

    private af(ImagePbActivity imagePbActivity) {
        this.f2153a = imagePbActivity;
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
            if (this.f2153a.G == null || this.f2153a.G.h() == null || this.f2153a.G.h().get(this.f2153a.J) == null) {
                return null;
            }
            String str = this.f2153a.G.h().get(this.f2153a.J).b() + "_big";
            if (str != null && str.length() > 0 && this.f2153a.G != null) {
                String f = com.baidu.tieba.util.bb.f(str);
                if (f != null) {
                    String str2 = f + Util.PHOTO_DEFAULT_EXT;
                    int i = 0;
                    while (com.baidu.tieba.util.x.b(str2) && i < 10000) {
                        i++;
                        str2 = f + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + Util.PHOTO_DEFAULT_EXT;
                    }
                    com.baidu.adp.widget.ImageView.e c = com.baidu.tbadk.imageManager.d.a().c(str);
                    if (c != null) {
                        str2 = com.baidu.tieba.util.x.a((String) null, str2, c.f(), 80);
                    }
                    if (str2 != null) {
                        new com.baidu.tieba.util.al(this.f2153a).a(str2);
                        return this.f2153a.getString(R.string.save_image_to_album);
                    }
                    return com.baidu.tieba.util.x.b();
                }
                return this.f2153a.getString(R.string.save_error);
            }
            return this.f2153a.getString(R.string.save_error);
        } catch (Exception e) {
            com.baidu.tieba.util.bd.b("SaveImageAsyncTask", "doInBackground", "error" + e.getMessage());
            return this.f2153a.getString(R.string.save_error);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        super.a((af) str);
        if (str != null) {
            this.f2153a.showToast(str);
        }
        this.f2153a.x = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.f2153a.x = null;
        super.cancel(true);
    }
}
