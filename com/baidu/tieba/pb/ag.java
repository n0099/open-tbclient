package com.baidu.tieba.pb;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ag extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ ImagePbActivity a;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ String a(String... strArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(String str) {
        String str2 = str;
        super.a((ag) str2);
        if (str2 != null) {
            this.a.showToast(str2);
        }
        this.a.x = null;
    }

    private ag(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ag(ImagePbActivity imagePbActivity, byte b) {
        this(imagePbActivity);
    }

    private String d() {
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
            com.baidu.adp.lib.util.e.b("SaveImageAsyncTask", "doInBackground", "error" + e.getMessage());
            return this.a.getString(R.string.save_error);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        this.a.x = null;
        super.cancel(true);
    }
}
