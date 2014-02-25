package com.baidu.tieba.pb;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends BdAsyncTask<String, Integer, String> {
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
        com.baidu.tieba.data.ab abVar;
        com.baidu.tieba.data.ab abVar2;
        com.baidu.tieba.data.ab abVar3;
        int i;
        com.baidu.tieba.data.ab abVar4;
        int i2;
        com.baidu.tieba.data.ab abVar5;
        String f;
        try {
            abVar = this.a.G;
            if (abVar != null) {
                abVar2 = this.a.G;
                if (abVar2.h() != null) {
                    abVar3 = this.a.G;
                    LinkedList<com.baidu.tieba.data.aa> h = abVar3.h();
                    i = this.a.J;
                    if (h.get(i) == null) {
                        return null;
                    }
                    abVar4 = this.a.G;
                    LinkedList<com.baidu.tieba.data.aa> h2 = abVar4.h();
                    i2 = this.a.J;
                    String str = String.valueOf(h2.get(i2).b()) + "_big";
                    if (str != null && str.length() > 0) {
                        abVar5 = this.a.G;
                        if (abVar5 != null) {
                            if (com.baidu.tieba.util.bs.f(str) != null) {
                                String str2 = String.valueOf(f) + ".jpg";
                                int i3 = 0;
                                while (com.baidu.tieba.util.af.b(str2) && i3 < 10000) {
                                    i3++;
                                    str2 = String.valueOf(f) + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + ".jpg";
                                }
                                com.baidu.adp.widget.ImageView.b c = com.baidu.tbadk.imageManager.e.a().c(str);
                                if (c != null) {
                                    str2 = com.baidu.tieba.util.af.a((String) null, str2, c.h(), 80);
                                }
                                if (str2 != null) {
                                    new com.baidu.tieba.util.ay(this.a).a(str2);
                                    return this.a.getString(R.string.save_image_to_album);
                                }
                                return com.baidu.tieba.util.af.b();
                            }
                            return this.a.getString(R.string.save_error);
                        }
                    }
                    return this.a.getString(R.string.save_error);
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("SaveImageAsyncTask", "doInBackground", "error" + e.getMessage());
            return this.a.getString(R.string.save_error);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        super.a((ag) str);
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
