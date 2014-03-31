package com.baidu.tieba.pb.image;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.bc;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ ImagePbActivity a;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ String a(String... strArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(String str) {
        String str2 = str;
        super.a((x) str2);
        if (str2 != null) {
            this.a.showToast(str2);
        }
        this.a.x = null;
    }

    private x(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ x(ImagePbActivity imagePbActivity, byte b) {
        this(imagePbActivity);
    }

    private String a() {
        com.baidu.tieba.data.u uVar;
        com.baidu.tieba.data.u uVar2;
        com.baidu.tieba.data.u uVar3;
        int i;
        com.baidu.tieba.data.u uVar4;
        int i2;
        com.baidu.tieba.data.u uVar5;
        String f;
        try {
            uVar = this.a.G;
            if (uVar != null) {
                uVar2 = this.a.G;
                if (uVar2.h() != null) {
                    uVar3 = this.a.G;
                    LinkedList<com.baidu.tieba.data.t> h = uVar3.h();
                    i = this.a.J;
                    if (h.get(i) == null) {
                        return null;
                    }
                    uVar4 = this.a.G;
                    LinkedList<com.baidu.tieba.data.t> h2 = uVar4.h();
                    i2 = this.a.J;
                    String str = String.valueOf(h2.get(i2).b()) + "_big";
                    if (str != null && str.length() > 0) {
                        uVar5 = this.a.G;
                        if (uVar5 != null) {
                            if (bc.f(str) != null) {
                                String str2 = String.valueOf(f) + ".jpg";
                                int i3 = 0;
                                while (com.baidu.tbadk.core.util.w.b(str2) && i3 < 10000) {
                                    i3++;
                                    str2 = String.valueOf(f) + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + ".jpg";
                                }
                                com.baidu.adp.widget.ImageView.b c = com.baidu.tbadk.imageManager.e.a().c(str);
                                if (c != null) {
                                    str2 = com.baidu.tbadk.core.util.w.a((String) null, str2, c.h(), 80);
                                }
                                if (str2 != null) {
                                    new ai(this.a).a(str2);
                                    return this.a.getString(com.baidu.tieba.a.k.save_image_to_album);
                                }
                                return com.baidu.tbadk.core.util.w.b();
                            }
                            return this.a.getString(com.baidu.tieba.a.k.save_error);
                        }
                    }
                    return this.a.getString(com.baidu.tieba.a.k.save_error);
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("SaveImageAsyncTask", "doInBackground", "error" + e.getMessage());
            return this.a.getString(com.baidu.tieba.a.k.save_error);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        this.a.x = null;
        super.cancel(true);
    }
}
