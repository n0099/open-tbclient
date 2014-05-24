package com.baidu.tieba.pb.image;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.be;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ ImagePbActivity a;

    private w(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ w(ImagePbActivity imagePbActivity, w wVar) {
        this(imagePbActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        com.baidu.tieba.data.u uVar;
        com.baidu.tieba.data.u uVar2;
        com.baidu.tieba.data.u uVar3;
        int i;
        com.baidu.tieba.data.u uVar4;
        int i2;
        com.baidu.tieba.data.u uVar5;
        String f;
        try {
            uVar = this.a.F;
            if (uVar != null) {
                uVar2 = this.a.F;
                if (uVar2.g() != null) {
                    uVar3 = this.a.F;
                    LinkedList<com.baidu.tieba.data.t> g = uVar3.g();
                    i = this.a.I;
                    if (g.get(i) == null) {
                        return null;
                    }
                    uVar4 = this.a.F;
                    LinkedList<com.baidu.tieba.data.t> g2 = uVar4.g();
                    i2 = this.a.I;
                    String str = String.valueOf(g2.get(i2).b()) + "_big";
                    if (str != null && str.length() > 0) {
                        uVar5 = this.a.F;
                        if (uVar5 != null) {
                            if (be.f(str) != null) {
                                String str2 = String.valueOf(f) + ".jpg";
                                int i3 = 0;
                                while (com.baidu.tbadk.core.util.x.b(str2) && i3 < 10000) {
                                    i3++;
                                    str2 = String.valueOf(f) + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + ".jpg";
                                }
                                com.baidu.adp.widget.a.a c = com.baidu.tbadk.imageManager.e.a().c(str);
                                if (c != null) {
                                    str2 = com.baidu.tbadk.core.util.x.a((String) null, str2, c.h(), 80);
                                }
                                if (str2 != null) {
                                    new aj(this.a).a(str2);
                                    return this.a.getString(com.baidu.tieba.y.save_image_to_album);
                                }
                                return com.baidu.tbadk.core.util.x.b();
                            }
                            return this.a.getString(com.baidu.tieba.y.save_error);
                        }
                    }
                    return this.a.getString(com.baidu.tieba.y.save_error);
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            BdLog.e("SaveImageAsyncTask", "doInBackground", "error" + e.getMessage());
            return this.a.getString(com.baidu.tieba.y.save_error);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        super.onPostExecute(str);
        if (str != null) {
            this.a.showToast(str);
        }
        this.a.w = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.a.w = null;
        super.cancel(true);
    }
}
