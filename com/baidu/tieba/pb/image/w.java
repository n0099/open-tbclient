package com.baidu.tieba.pb.image;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bm;
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
        com.baidu.tieba.data.w wVar;
        com.baidu.tieba.data.w wVar2;
        com.baidu.tieba.data.w wVar3;
        int i;
        com.baidu.tieba.data.w wVar4;
        int i2;
        com.baidu.tieba.data.w wVar5;
        String f;
        try {
            wVar = this.a.F;
            if (wVar != null) {
                wVar2 = this.a.F;
                if (wVar2.g() != null) {
                    wVar3 = this.a.F;
                    LinkedList<com.baidu.tieba.data.v> g = wVar3.g();
                    i = this.a.I;
                    if (g.get(i) == null) {
                        return null;
                    }
                    wVar4 = this.a.F;
                    LinkedList<com.baidu.tieba.data.v> g2 = wVar4.g();
                    i2 = this.a.I;
                    String str = String.valueOf(g2.get(i2).b()) + "_big";
                    if (str != null && str.length() > 0) {
                        wVar5 = this.a.F;
                        if (wVar5 != null) {
                            if (bm.f(str) != null) {
                                String str2 = String.valueOf(f) + ".jpg";
                                int i3 = 0;
                                while (com.baidu.tbadk.core.util.z.b(str2) && i3 < 10000) {
                                    i3++;
                                    str2 = String.valueOf(f) + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + ".jpg";
                                }
                                com.baidu.adp.widget.a.a c = com.baidu.tbadk.imageManager.e.a().c(str);
                                if (c != null) {
                                    str2 = com.baidu.tbadk.core.util.z.a((String) null, str2, c.h(), 80);
                                }
                                if (str2 != null) {
                                    new ao(this.a).a(str2);
                                    return this.a.getString(com.baidu.tieba.y.save_image_to_album);
                                }
                                return com.baidu.tbadk.core.util.z.b();
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
            BdLog.e(e.getMessage());
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
