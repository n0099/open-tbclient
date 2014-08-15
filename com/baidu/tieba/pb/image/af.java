package com.baidu.tieba.pb.image;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ ac a;
    private com.baidu.tbadk.core.util.ae b = null;
    private int c;
    private int d;
    private String e;
    private String f;
    private x g;
    private String h;

    public af(ac acVar, x xVar, int i, int i2, String str, String str2) {
        this.a = acVar;
        this.c = 0;
        this.d = 10;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.c = i;
        this.d = i2;
        this.e = str;
        this.f = str2;
        this.g = xVar;
        this.h = xVar.e().d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        if (this.g != null) {
            this.g.a(true);
            this.g.notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        String str;
        this.b = new com.baidu.tbadk.core.util.ae(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/pb/piccomment");
        com.baidu.tbadk.core.util.ae aeVar = this.b;
        str = this.a.d;
        aeVar.a("kw", str);
        this.b.a("pic_id", this.f);
        this.b.a("tid", this.e);
        this.b.a("pn", String.valueOf(this.c));
        this.b.a("rn", String.valueOf(this.d));
        this.b.a("alt", "json");
        this.b.a().a().a = true;
        return this.b.h();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.f();
        }
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
        if (this.g != null) {
            this.g.a(false);
            this.g.notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Incorrect condition in loop: B:22:0x0080 */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPostExecute(String str) {
        Context context;
        Context context2;
        HashMap hashMap;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        HashMap hashMap2;
        com.baidu.tieba.data.x xVar = null;
        super.onPostExecute(str);
        try {
            if (this.g != null) {
                this.g.a(false);
            }
            if (this.b != null) {
                if (!this.b.a().b().b() || this.g == null) {
                    context = this.a.b;
                    context2 = this.a.b;
                    ((BaseActivity) context).showToast(context2.getString(com.baidu.tieba.x.image_pb_comment_fail));
                    return;
                }
                if (this.g != null) {
                    this.g.a((com.baidu.tieba.data.x) null);
                    this.g.notifyDataSetChanged();
                }
                hashMap = this.a.g;
                if (hashMap.get(this.g.e().d()) != null) {
                    hashMap2 = this.a.g;
                    xVar = (com.baidu.tieba.data.x) hashMap2.get(this.g.e().d());
                    xVar.a(str);
                }
                if (this.g != null) {
                    this.g.a(xVar);
                    this.g.notifyDataSetChanged();
                    this.g = null;
                }
                for (int i = 0; i < arrayList.size(); i++) {
                    arrayList2 = this.a.q;
                    if (((View) arrayList2.get(i)).getTag() instanceof x) {
                        arrayList3 = this.a.q;
                        x xVar2 = (x) ((View) arrayList3.get(i)).getTag();
                        if (xVar2.e() != null && this.h.equals(xVar2.e().d())) {
                            xVar2.notifyDataSetChanged();
                        }
                    }
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
